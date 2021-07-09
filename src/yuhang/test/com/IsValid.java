package yuhang.test.com;

import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(new IsValid().isValid(s));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();

        if(length == 0) return true;

        stack.push(s.charAt(0));
        for(int i = 1; i < length; i++){
            char bracket = s.charAt(i);
            if(!stack.isEmpty()) {
                if (bracket == '(' || bracket == ')') {
                    int val =  bracket - stack.peek();
                    if(val != 1){
                        stack.push(bracket);
                    }else stack.pop();
                }
                if (bracket == '[' || bracket == ']'){
                    int val =  bracket - stack.peek();
                    if(val != 2){
                        stack.push(bracket);
                    }else stack.pop();
                }
                if (bracket == '{' || bracket == '}'){
                    int val =  bracket - stack.peek();
                    if(val != 2){
                        stack.push(bracket);
                    }else stack.pop();
                }
            }else{
                stack.push(bracket);
            }
        }
        return stack.isEmpty();
    }
}
