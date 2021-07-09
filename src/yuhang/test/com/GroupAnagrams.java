package yuhang.test.com;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        char i1 = 'l';
        char i2 = 'i';
        char i3 = 'd';
        char i4 = 'u';
        char i5 = 'h';
        int value2 = 'd' + 'u' + 'h';
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
