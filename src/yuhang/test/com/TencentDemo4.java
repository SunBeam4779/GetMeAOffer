package yuhang.test.com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class TencentDemo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] data = new int[num];
        for (int i = 0; i < num; i++){
            data[i] = scanner.nextInt();
        }
        int length = scanner.nextInt();
        var list = new LinkedList<Integer>();
        list.removeLast();
        System.out.print(solution(data, length));
    }

    public static int solution(int[] data, int length){
        int size = data.length;
        Arrays.sort(data);
        boolean[] mark = new boolean[size];
        int record = 0;
        for (int i = size - 1; i >= 0; i--){
            if (data[i] > length) continue;

            if (record + data[i] < length) {
                record += data[i];
                mark[i] = true;
            }
        }
        for (int i = size - 1; i >= 0; i--){
            if(mark[i]) continue;
            record += data[i];
            if(record > length) break;
        }
        return record;
    }
}
