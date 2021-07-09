package yuhang.test.com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Test1 {
    static int result = 1;
    public static void main(String[] args) {
        int num = 21;
        int w = 1165911996;
        long[] data = new long[]{842104736, 130059605, 359419358, 682646280, 378385685, 622124412, 740110626, 814007758, 557557315, 40153082, 542984016, 274340808, 991565332, 765434204, 225621097, 350652062, 714078666, 381520025, 613885618, 64141537, 783016950};
        long count = 0;
        int res = 0;
//        Arrays.sort(data);
        for(long item:data){
            count += item;
        }
        if(count <= w)
            res = (int)Math.pow(2, num);
        else{
            solution(data, 0, w, 0);
            res = result;
        }

        System.out.println(res);

        Stack<String> strings = new Stack<>();
        String s = "01234";
        while(s.length() >= 1){
            strings.push(s);
            s = s.substring(1);
        }
        for (String item:strings)
            System.out.println(item);
    }

//    public static void solution(long[] data, int w){
//        HashMap<Long, Integer> hashMap = new HashMap<>();
//        long[] F = new long[w + 1];
//        Arrays.fill(F, 1);
//        for (int i = 0; i < data.length; i++){
//            for (int v = w; v >= data[i]; v--){
//                F[v] = F[v] + F[v - data[i]];
//            }
//        }
//        System.out.println(F[w]);
//    }
//    public static int solution(int[] data, int w){
//        int count = 0;
//        if (data[data.length - 1] < w)
//            for(int item:data){
//                if (w - count > item)
//                    count += item;
//                else{
//                    count = w + 1;
//                    break;
//                }
//
//            }
//            if(count <= w)
//                return (int)Math.pow(2, data.length);
//
//        int[][] F = new int[data.length + 1][w + 1];
//        for (int i = 0; i < w + 1; i++){
//            F[0][i] = 1;
//        }
//        for (int i = 0; i < data.length + 1; i++){
//            F[i][0] = 1;
//        }
//        for (int i = 1; i <= data.length; i++){
//            for (int v = 1; v <= w; v++){
//                if (v < data[i - 1]) F[i][v] = F[i - 1][v];
//                else
//                    F[i][v] = F[i - 1][v] + F[i][v - data[i - 1]];
//            }
//        }
//        return F[data.length][w];
//    }
    public static void solution(long[] data, int index, int w, long cnt){
        if (index == data.length) return;
        if (cnt + data[index] <= w){
            result++;
            solution(data, index + 1, w, cnt + data[index]);
        }
        solution(data, index + 1, w, cnt);
    }
}
