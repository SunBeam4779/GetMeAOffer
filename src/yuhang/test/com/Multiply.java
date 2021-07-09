package yuhang.test.com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Multiply {
    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "9";
        char item = '0';
        System.out.println(item);
        System.out.println(new Multiply().multiply(num1, num2));
    }
    int len = 0;
    char[] data;
//    public String multiply(String num1, String num2) {
//        String result;
//        int length1 = num1.length();
//        int length2 = num2.length();
//        Queue<char[]> queue = new LinkedList<>();
//        for(int i = length1 - 1; i >= 0; i--){
//            queue.offer(mul(num1.charAt(i), num2));
//        }
//        return getRes(queue);
//
//    }

//    public char[] mul(char num, String nums){
//        int length = nums.length();
//        int add = 0;
//        char[] data = nums.toCharArray();
//        for(int i = length - 1; i >= 0; i--){
//            int temp = (num - '0') * (data[i] - '0') + add;
//            if(temp > 9){
//                data[i] = (char)(temp % 10 + '0');
//                add = temp / 10;
//            } else{
//                data[i] = (char)(temp + '0');
//                add = 0;
//            }
//        }
//
//        if(add >= 1){
//            if(len <= length) len = length;
//            char[] res = new char[length + 1];
//            res[0] = (char)(add + '0');
//            System.arraycopy(data, 0, res, 1, data.length);
//            data = res;
//            return data;
//        }
//        if(len <= length) len = length;
//        return data;
//    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        String result;
        int length1 = num1.length();
        int length2 = num2.length();
        len = length1 + length2;
        data = new char[len];
        for(int i = 0; i < len; i++){
            data[i] = '0';
        }
        // Queue<char[]> queue = new LinkedList<>();
        int pos = len - 1;
        for(int i = length1 - 1; i >= 0; i--){
            // queue.offer(mul(num1.charAt(i), num2));

            mul(num1.charAt(i), num2, pos);
            pos --;
        }

        result = String.copyValueOf(data);
        if(result.startsWith("0")){
            return result.substring(1);
        }
        return result;

    }

    public void mul(char num, String nums, int pos){
        int length = nums.length();
        int add = 0;
        char[] val = nums.toCharArray();
        int j = pos;
        for(int i = length - 1; i >= 0; i--){
            int temp = (num - '0') * (val[i] - '0') + add;
            if(temp > 9){
                val[i] = (char)(temp % 10 + '0');
                add = temp / 10;
            } else{
                val[i] = (char)(temp + '0');
                add = 0;
            }
        }

        if(add >= 1){
            // if(len <= length) len = length;
            char[] res = new char[length + 1];
            res[0] = (char)(add + '0');
            System.arraycopy(val, 0, res, 1, val.length);
            val = res;
            // return data;
        }
        add = 0;
        for(int i = val.length - 1; i >= 0; i--){
            int temp = (data[j] - '0') + (val[i] - '0') + add;
            if(temp > 9){
                data[j] = (char)(temp - 10 + '0');
                add = 1;
            }else{
                data[j] = (char)(temp + '0');
                add = 0;
            }
            j--;
        }
        if(add == 1) data[j] = (char)(data[j] + 1);

        // if(len <= length) len = length;
        // return data;
    }

    public String getRes(Queue<char[]> data){
        int size = len + data.size();
        char[] res = new char[size];
        for (char i = 0; i < size; i++
             ) {
            res[i] = 48;
        }
        int pos = size - 1;
        int add = 0;
        while(!data.isEmpty()){
            char[] temp = data.poll();
            int j = pos;
            for(int i = temp.length - 1; i >= 0; i--){
                int val = (res[j] - '0') + (temp[i] - '0') + add;
                if(val > 9){
                    res[j] = (char)(val - 10 + '0');
                    add = 1;
                }else{
                    res[j] = (char)(val + '0');
                    add = 0;
                }
                j--;
            }
            if(add == 1) res[j] = (char)(res[j] + 1);
            add = 0;
            pos--;
        }

        String re = String.copyValueOf(res);
        if(re.startsWith("0")){
            return re.substring(1);
        }
        return re;
    }
}