package yuhang.test.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommonCharacters {
    public static void main(String[] args) {
        String[] data = {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
        CommonCharacters commonCharacters = new CommonCharacters();
        var list = commonCharacters.commonChars(data);
        for (String item:list){
            System.out.println(item);
        }
        StringBuilder stringBuilder = new StringBuilder();
        
    }
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if(A.length == 0) return result;
        int[] map = new int[26];
        Arrays.fill(map, Integer.MAX_VALUE);
        int length = A.length;
        String first = A[0];
        for (String s : A) {
            int[] record = new int[26];
            char[] temp = s.toCharArray();
            for (char c : temp) {
                int pos = c - 'a';
                record[pos]++;
            }
            for (int i = 0; i < 26; ++i){
                map[i] = Math.min(map[i], record[i]);
            }
        }
        for(int i = 0; i < 26; ++i){
            if(map[i] != 0){
                int count = map[i];
                for(int j = 0; j < count; ++j)
                    result.add(String.valueOf((char)(i + 'a')));
            }
        }
        return result;
    }
}
