package yuhang.test.com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CheckOdd {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int length = scanner.nextInt();
//        scanner.nextInt();
//        String[] strings = new String[length];
//        int[] start = new int[length];
//        int[] end = new int[length];
//        for (int i = 0; i < length; i++){
//            strings[i] = scanner.next();
//            start[i] = scanner.nextInt();
//            end[i] = scanner.nextInt();
//            scanner.nextLine();
//            System.out.println(process(strings[i], start[i], end[i]));
//        }
        HashSet<Character> set = new HashSet<>();
        
        HashMap<Character, Character> hashMap = new HashMap<>();
        System.out.println(process("4D", 2, 4));

    }


    public static int process(String s, int start, int end){
        int res = 0;
        for(int i = start; i <= end; i++){
            res += change(s, i);
        }
        return res % 2;
    }

    public static int change(String s, int val){
        int length = s.length();
        int res = 0;
        for(int i = 0; i < length; i++){
            int temp = s.charAt(i);
            if(temp >= 'A' && temp <= 'F') temp = temp - 'A' + 10;
            else temp -= '0';
            res *= val;
            res += temp;
        }
        return res;
    }
}
