package yuhang.test.com;

import java.util.Stack;

public class UncompressingString {
    Stack<String> stack = new Stack<>();
    public static void main(String[] args) {
        String s = "[2|[2|A]D]";
        UncompressingString uncompressingString = new UncompressingString();
        String res = uncompressingString.solution(s);
        System.out.println(res);
        
    }
//    public String process(String string){
//        int length = string.length();
//        int start = 0;
//        for(int i = 0; i < length; i++){
//
//            if(string.charAt(i) == '['){
////                if(start == i) {
////                    start += 1;
////                    continue;
////                }
//                stack.push(string.substring(start, i));
//                start = i + 1;
//            }
//            if(string.charAt(i) == '|'){
//                stack.push(string.substring(start, i));
//                start = i + 1;
//            }
//            if(string.charAt(i) == ']'){
//                String back = string.substring(start, i);
//                start = i + 1;
//                String temp;
//                int N;
//                String pre;
//                String top = stack.pop();
//                if(top.charAt(0) >= 'A' && top.charAt(0) <= 'Z'){
//                    pre = top;
//                    pre += back;
//                }else{
//                    N = Integer.parseInt(top);
//                    StringBuilder s = new StringBuilder();
//                    int count = 0;
//                    while(count < N){
//                        s.append(back);
//                        count++;
//                    }
//                    pre = stack.pop();
//                    pre += s;
//                }
//                stack.push(pre);
//            }
//
//        }
//        if(stack.isEmpty()) return string;
//        while(stack.size() >= 2){
//            String back = stack.pop();
//            int N;
//            String pre;
//            String top = stack.pop();
//            if(top.charAt(0) >= 'A' && top.charAt(0) <= 'Z'){
//                pre = top;
//                pre += back;
//            }else{
//                N = Integer.parseInt(top);
//                StringBuilder s = new StringBuilder();
//                int count = 0;
//                while(count < N){
//                    s.append(back);
//                    count++;
//                }
//                pre = stack.pop();
//                pre += s;
//            }
//            stack.push(pre);
//        }
//        return stack.pop() + string.substring(start);
//    }
    public String solution(String string){
        int length = string.length();
        Stack<Character> record = new Stack<>();
        Stack<String> sub = new Stack<>();

        for(int i = length - 1; i >= 0; i--){
            char temp = string.charAt(i);
            if(temp >= 'A' && temp <= 'Z'){
                record.push(temp);
                sub.push(String.valueOf(temp));
            }
            if(temp == ']' || temp == '|' || (temp >= '0' && temp <= '9')) record.push(temp);
            if(temp == '['){
                StringBuilder sb = new StringBuilder();
                StringBuilder num = new StringBuilder();
                while(!record.isEmpty()){
                    if(record.peek() != '|'){
                        num.append(record.pop());
                    }else{
                        record.pop();
                        break;
                    }
                }
                int dis = Integer.parseInt(num.toString());
                while(!sub.isEmpty()){
                    if(record.peek() != ']'){
                        sb.append(sub.pop());
                        record.pop();
                    }else{
                        record.pop();
                        break;
                    }

                }
                String sh = sb.toString();

                sb.append(sh.repeat(Math.max(0, dis - 1)));
                while(!sub.isEmpty()){
                    if(record.peek() != ']'){
                        sb.append(sub.pop());
                        record.pop();
                    }else{
                        record.pop();
                        break;
                    }

                }
                sub.push(sb.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        while(!sub.isEmpty()){
            result.append(sub.pop());
        }
        return result.toString();
    }
}
