package yuhang.test.com;

import java.util.Arrays;

public class FindNthDigit {
    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        int[] value = {3, 30, 34, 5, 9};
        String[] data = new String[value.length];
        for (int i = 0; i < value.length; i++
             ) {
            data[i] = String.valueOf(value[i]);
        }
        Arrays.sort(data);
        for(String item:data){
            System.out.println(item);
        }

        System.out.println(findNthDigit.findNthDigit(1000000000));
    }
    public int findNthDigit(int n) {
        long count = 9;
        long start = 1;
        long digits = 1;
        while(count < n){
            n = (int)(n - count);
            start *= 10;
            digits++;
            count = 9 * start * digits;
        }
        long num = start + (n - 1) / digits;
        int pos = (int)((n - 1) % digits);

        String res = Long.toString(num);
        return res.charAt(pos) - '0';

    }
}
