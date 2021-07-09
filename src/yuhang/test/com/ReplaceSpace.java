package yuhang.test.com;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReplaceSpace {
    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String s = "We are happy.";
        System.out.println(replaceSpace.replaceSpace(s));
    }

    public String replaceSpace(String s) {
        if(s.equals("")) return s;
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        int length = s.length();
        for(int i = 0; i < length; i++){
            if(s.charAt(i) == ' '){
//                stack.push('0');
//                stack.push('2');
//                stack.push('%');
                queue.offer('%');
                queue.offer('2');
                queue.offer('0');
            }else{
//                stack.push(s.charAt(i));
                queue.offer(s.charAt(i));
            }
        }
        return queue.toString();
//        StringBuilder string = new StringBuilder();
//        string.append(stack.pop());
//        while(!stack.isEmpty()){
//            string.append(stack.pop());
//        }
//        return string.toString();
    }
}
