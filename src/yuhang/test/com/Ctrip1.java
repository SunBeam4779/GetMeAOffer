package yuhang.test.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Ctrip1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = "you"; // scanner.nextLine();
        String string = "I love you,yuo love me."; // scanner.nextLine();
        String word = "jack"; // scanner.nextLine();
        var list = new ArrayList<Integer>();
        Collections.sort(list);
        System.out.println(new Ctrip1().solution(string, target, word));
    }
    HashSet<String> bag = new HashSet<>();
    int length;
    char[] letter;
    boolean[] marked;
    public String solution(String string, String target, String word){
        length = target.length();
        int lenOfStr = string.length();
        letter = target.toCharArray();
        marked = new boolean[length];
        process(new StringBuilder());
        ArrayList<String> record = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        int start = 0;
        int end = 0;
        boolean punc = false;
        String[] words = string.split("[\\pP\\pS\\pZ]");
        for(; end < string.length(); end++){
            if(!punc) {
                if (string.charAt(end) < 'a' && string.charAt(end) > 'Z') {
                    String temp = string.substring(start, end);
                    if (bag.contains(temp)) temp = word;
                    record.add(temp);
                    start = end;
                    punc = true;
                }
            }else{
                
            }
        }
//        for (String s : words) {
//            if (bag.contains(s)) {
//                res.append(word);
//            } else {
//                res.append(s);
//            }
//        }
        String temp = res.toString();

//        res.append(string.substring(i));
        return res.toString();
    }

    public void process(StringBuilder sb){

        if(sb.length() == length){
            bag.add(sb.toString());
            return;
        }

        StringBuilder stringBuilder = new StringBuilder(sb);
        int size = stringBuilder.length();
        for (int i = 0; i < length; i++){
            if(marked[i]) continue;
            stringBuilder.append(letter[i]);
            marked[i] = true;
            process(stringBuilder);
            stringBuilder.delete(size, size + 1);
            marked[i] = false;
        }
    }

}
