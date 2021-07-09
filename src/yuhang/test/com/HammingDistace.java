package yuhang.test.com;

import java.util.Stack;

public class HammingDistace {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        HammingDistace hammingDistace = new HammingDistace();
        System.out.println(hammingDistace.hammingDistance(x, y));
    }
    public int hammingDistance(int x, int y) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(x != 0 || y != 0){
            int temp1 = 0;
            int temp2 = 0;
            if (x != 0) temp1 = 1 & x;
            if (y != 0) temp2 = 1 & y;
            stack1.push(temp1);
            stack2.push(temp2);
            x = x >> 1;
            y = y >> 1;
        }
        int result = 0;
        while(!stack2.empty() || !stack2.empty()){
            if(stack1.empty()){
                if(stack2.peek() == 1){
                    result++;
                }
                stack2.pop();
            }
            else if(stack2.empty()){
                if(stack1.peek() == 1){
                    result++;
                }
                stack1.pop();
            }
            else {

                if(!stack1.peek().equals(stack2.peek())) result++;
                stack2.pop();
                stack1.pop();
            }
        }
        return result;
    }
}
