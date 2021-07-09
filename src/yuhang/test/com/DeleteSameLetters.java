package yuhang.test.com;

import java.util.HashSet;

public class DeleteSameLetters {
    public static void main(String[] args) {
        String s = "hello, welcome to xiaomi.";
        DeleteSameLetters deleteSameLetters = new DeleteSameLetters();
        System.out.println(deleteSameLetters.solution(s));
        String a = "123";
        String b = "123";
        String c = new String("123");
        System.out.println(a == b);
        System.out.println(a.equals(c));
        int i;
        int k;
        for(i = 0, k = 0; ++i <10; i++, k++);
        System.out.println(i);
        System.out.println(k);
    }
    public String solution(String s){
        HashSet<Character> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        int length = s.length();
        for(int i = 0; i < length; i++){
            char temp = s.charAt(i);
            if(!set.contains(temp)){
                set.add(temp);
                stringBuilder.append(temp);
            }
        }
        return stringBuilder.toString();
    }
}
