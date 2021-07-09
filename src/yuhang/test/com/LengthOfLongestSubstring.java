package yuhang.test.com;

import java.util.*;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        ArrayList<Integer> arrayList = new ArrayList<>();

    }
    int[] map;
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length == 0) return 0;
        map = new int[52];
        int max = 1;
        Arrays.fill(map, -1);
        map[s.charAt(0) - 'a'] = 0;
        int lo = 0;
        int hi = 1;
        while(hi < length){

            int temp = s.charAt(hi) - 'a';

            if(map[temp] != -1){
                int index = map[temp];
                if(index >= lo){
                    lo = index + 1;
                }
            }
            map[temp] = hi;
            int distance = hi - lo + 1;
            if(distance > max) max = distance;
            hi++;
        }
        return max;
    }
}