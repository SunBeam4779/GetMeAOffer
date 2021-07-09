package yuhang.test.com;

import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String strings = "cat cat cat cat";
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern(pattern, strings));
    }

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        String[] strings = s.split(" ");
        if(pattern.length() != strings.length) return false;
        int index = 0;
        
        for(String str: strings){
            char c = pattern.charAt(index++);
            if(!map.containsKey(c))
                map.put(c, str);
            else {
                if (!map.get(c).equals(str)) return false;
            }
            if(!map2.containsKey(str)){
                map2.put(str, c);
            }
            else{
                if (map2.get(str) != c) return false;
            }
        }
        return true;
    }
}
