package yuhang.test.com;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        String s = "010010";
//        String s2 = s.substring(10);
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        List<String> strings = restoreIPAddresses.restoreIpAddresses(s);
        for (String item: strings){
            System.out.println(item);
        }
    }
    List<String> res;
    int length = 0;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        length = s.length();
        if(length <= 3 || length > 12) return res;
        // length += 3;
        check(s, "", 3);
        return res;
    }

    public void check(String s, String sub, int count){
        if (count == 0){
            if (s.length() >=4 || s.length() == 0) return;
            else{
                if (Integer.parseInt(s) > 255) return;
                else{
                    if(s.startsWith("0") && s.length() > 1) return;
                    else res.add(sub + "." + s);
                }
            }
        }
        for(int i = 1; i <= 3 && i < s.length(); i++){
            String temp = s.substring(0, i);
            if(temp.startsWith("0") && i > 1) continue;
            if (Integer.parseInt(temp) <= 255){
                if (sub.equals("")) check(s.substring(i, length), temp,count - 1);
                else check(s.substring(i), sub + "." + temp,count - 1);
            }
        }
    }
}
