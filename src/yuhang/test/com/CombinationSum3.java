package yuhang.test.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        var result = combinationSum3.combinationSum3(3, 7);
        for (var list:result){
            for (var item:list){
                System.out.println(item);
            }
        }
    }
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] data = new int[9];
        int[] trace = new int[9];
        result = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            data[i] = i + 1;
        }
        boolean[] mark = new boolean[9];
        solution(data, mark, new ArrayList<>(), k, n);
        return result;
    }

    public void solution(int[] data, boolean[] mark, List<Integer> record, int k, int n){
        if(record.size() == k) {
            if (n == 0) {
                List<Integer> temp = new ArrayList<>(record);
                Collections.sort(temp);
                if(!result.contains(temp)) result.add(new ArrayList<>(temp));
            }
            return;
        }
        if(n < 0) return;

        for(int i = 0; i < data.length; i++){
            if(mark[i]) continue;
            if(data[i] <= n){
                mark[i] = true;
                record.add(data[i]);
                solution(data, mark, record, k, n - data[i]);
                mark[i] = false;
                record.remove(record.size() - 1);
            }
        }
    }
}
