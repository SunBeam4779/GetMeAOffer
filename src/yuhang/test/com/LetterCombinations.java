package yuhang.test.com;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        String s = "23";
        LetterCombinations letterCombination = new LetterCombinations();
        List<String> res = letterCombination.letterCombinations(s);
        for (String item:res){
            System.out.println(item);
        }
        System.out.println(Integer.MAX_VALUE);
    }
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        char[] data = new char[length];
        List<String> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        char[] temp = getChar(digits.charAt(0));
        for (char c : temp) {
            list.add(String.valueOf(c));
        }
        return process(list, digits, 1);
    }
    public List<String> process(List<String> data, String s, int index){
        if(index == s.length()) return data;
        char[] item = getChar(s.charAt(index));
        List<String> res = new ArrayList<>();
        for (char c : item) {
            for (String datum : data) {
                res.add(datum + c);
            }
        }
        return process(res, s, index + 1);
    }
    public char[] getChar(char num){
        char[] res = null;
        if(num >= '2' && num <= '6'){
            res = new char[3];
            num = (char)((num - '2') * 3 + 'a');
            for(int i = 0; i < 3; i++){
                res[i] = num;
                num += 1;
            }
        }
        if(num == '7'){
            res = new char[]{'p', 'q', 'r', 's'};
        }
        if(num == '8'){
            res = new char[]{'t', 'u', 'v'};
        }
        if(num == '9'){
            res = new char[]{'w', 'x', 'y', 'z'};
        }
        return res;
    }
}
