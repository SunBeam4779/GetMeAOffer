package yuhang.test.com;

import java.util.HashSet;

public class TranslateNum {
    public static void main(String[] args) {
        int data = 12258;
        TranslateNum translateNum = new TranslateNum();
        System.out.println(translateNum.translateNum(data));
        StringBuilder a = new StringBuilder("hello");
        StringBuilder b = new StringBuilder("world");
        translateNum.change(a, b);
        System.out.println(a + ", " + b);
    }
    public void change(StringBuilder A, StringBuilder B){
        A.append(B);
        B = A;
    }
    HashSet<String> set = new HashSet<>();
    public int translateNum(int num) {
//        String number = String.valueOf(num);
//        String head = "";
//        dfs(number, head);
//        return set.size();
        String number = String.valueOf(num);
        int[] data = new int[number.length()];
        data[0] = 1;
        for(int i = 1; i < data.length; i++){
            int count1 = 0;
            int value = (number.charAt(i - 1) - '0') * 10 + (number.charAt(i) - '0');
            if(value >= 10 && value <= 25){
                if(i - 2 >= 0) count1 = data[i - 2];
                else count1 = 1;
            }
            data[i] = count1 + data[i - 1];
        }
        return data[data.length - 1];
    }
    public void dfs(String data, String head){
        if(data.length() == 0){
            set.add(head);
            return;
        }
        String temp = head + (char)(data.charAt(0) - '0' + 'a');
        dfs(data.substring(1), temp);
        if(data.charAt(0) != '0' && data.length() > 1) {
            if(Integer.parseInt(data.substring(0, 2)) <= 25){
                String temp1 = head + data.substring(0, 2);
                dfs(data.substring(2), temp1);
            }
        }
    }
}
