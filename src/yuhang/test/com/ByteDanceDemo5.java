package yuhang.test.com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ByteDanceDemo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        int[][] price = new int[num][num];
//        for(int i = 0; i < num; i++){
//            for (int j = 0; j < num; j++){
//                price[i][j] = scanner.nextInt();
//            }
//        }
        int num = 5; // scanner.nextInt();
        int[][] price = new int[][]{
            {0, 6, 5, 7, 4, 3, 4, 5, 7, 9, 6, 5, 5, 8},
            {6, 0, 7, 4, 3, 3, 5, 4, 5, 7, 5, 4, 6, 6},
            {4, 4, 0, 5, 8},
            {2, 6, 5, 0, 6},
            {7, 3, 8, 6, 0}
        };
        int res = 1001 * num;

        for(int i = 1; i < num; i++){
            int temp = solution(price, i);
            if(temp < res) res = temp;
        }
        System.out.println(res);
    }
    public static int solution(int[][] data, int next){
        boolean[] mark = new boolean[data.length];
        mark[0] = true;
        mark[next] = true;
        int start = 0;
        int res = data[0][next];
        int visit = 1;
        while(visit < mark.length){
            int min = 1001;

            int index = next;
            for(int i = 0; i < data.length; i++){
                if(!mark[i] && data[next][i] < min) {
                    min = data[next][i];
                    index = i;
                }
            }
            if(index == next){
                res += data[next][0];
                break;
            }
            res += min;
            visit++;
            next = index;
            mark[next] = true;
        }
        return res;
    }
}
