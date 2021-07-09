package yuhang.test.com;

import javax.sql.rowset.spi.SyncResolver;
import java.util.*;

public class CountBinarySubstring {
    public static void main(String[] args) {
        String string = "10101";
        System.out.println(new CountBinarySubstring().countBinarySubstrings(string));
    }
    public int countBinarySubstrings(String s) {
//        int res = 0;
//        char[] string = s.toCharArray();
//        char temp = string[0];
//        Stack<Character> stack = new Stack<>();
//        stack.push(temp);
//        int i = 1;
//        boolean differ = false;
//        for(; i < string.length; i++){
//            if(temp == string[i]){
//                stack.push(string[i]);
//            }else {
//                differ = true;
//                break;
//            }
//        }
//        if(!differ) return 0;
//        int index = i;
//        char temp2 = string[index++];
//        stack.pop();
//        res += 1;
//        while(!stack.isEmpty() && index < string.length){
//            if(temp2 == string[index++]){
//                stack.pop();
//
//                res++;
//            }else{
//                stack.clear();
//            }
//        }
//        res += countBinarySubstrings(s.substring(i));
//        return res;
        char temp = s.charAt(0);
        int count = 1;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i < s.length(); i++){
            if(temp == s.charAt(i)){
                count += 1;
            }else{
                if (!stack.empty()) {
                    res += Math.min(stack.pop(), count);
                }
                stack.push(count);
                temp = s.charAt(i);
                count = 1;
            }
        }
        res += Math.min(stack.pop(), count);
        return res;
    }
}
