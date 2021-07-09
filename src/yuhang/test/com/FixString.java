package yuhang.test.com;

public class FixString {
    public static void main(String[] args) {
        String s = "woooooobbttt";
        System.out.println(new FixString().process(s));
    }
    public String process(String string) {
        int length = string.length();
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && string.charAt(i) == string.charAt(i + 1)) {
                if (i + 2 < length && string.charAt(i) == string.charAt(i + 2)) {
                    return string.substring(0, i) + process(string.substring(i + 1));
                }
                if (i + 3 < length && string.charAt(i + 2) == string.charAt(i + 3)) {
                    String temp = string.substring(i, i + 2) + string.substring(i + 3);
                    if (i == 0) return process(temp);
                    return string.substring(0, i) + process(temp);
                }
            }
        }
        return string;
    }
}
