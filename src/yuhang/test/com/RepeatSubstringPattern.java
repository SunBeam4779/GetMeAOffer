package yuhang.test.com;

public class RepeatSubstringPattern {
    String sub = "";
    int length;
    public static void main(String[] args) {
        String string = "abcabcabc";
//        string.indexOf()
        System.out.println(string.indexOf("abc", 1));
        System.out.println(new RepeatSubstringPattern().repeatedSubstringPattern(string));
    }
//    public boolean repeatedSubstringPattern(String s) {
//        return (s + s).indexOf(s, 1) != s.length();
//    }
    public boolean repeatedSubstringPattern(String s) {
        length = s.length();

        for(int i = 1; i <= length / 2; i++){
            String sub = s.substring(0, i);
            if(length % sub.length() != 0) continue;
            for(int j = i; j <= length; j += i){
                String temp = s.substring(j - i, j);
                if(!temp.equals(sub)) break;
                if(j == length) return true;
            }

        }
        return false;
    }
}
