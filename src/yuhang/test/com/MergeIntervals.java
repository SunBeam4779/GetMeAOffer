package yuhang.test.com;

import java.util.ArrayList;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] data = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        MergeIntervals mergeIntervals = new MergeIntervals();
        var res = mergeIntervals.merge(data);
        for (var array:res){
            for (int item:array){
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {
        int row = intervals.length;
        ArrayList<int[]> arrays = new ArrayList<>();
        arrays.add(intervals[0]);
        for(int i = 1; i < row; i++){
            int[] temp = arrays.get(arrays.size() - 1);
            if(intervals[i][0] < temp[1]){
                temp[1] = intervals[i][1];
                arrays.remove(arrays.size() - 1);
                arrays.add(temp);
            }else{
                arrays.add(intervals[i]);
            }
        }
        int[][] res = new int[arrays.size()][];
        for(int i = 0; i < arrays.size(); ++i){
            res[i] = arrays.get(i);
        }
        return res;
    }
}
