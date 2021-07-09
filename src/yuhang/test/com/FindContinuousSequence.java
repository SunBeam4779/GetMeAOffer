package yuhang.test.com;

import java.util.ArrayList;

public class FindContinuousSequence {
    public static void main(String[] args) {
        int target = 9;
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();

        int[][] result = findContinuousSequence.findContinuousSequence(target);
        for (int[] array:result){
            for (int item:array){
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> result = new ArrayList<>();
        int lo = 1;
        int hi = 2;
        while(lo <= target / 2){
            int count = 0;
            // int[] array = new int[hi - lo + 1];
            int index = 0;
            for(int i = lo; i <= hi; i++){
                count += i;
                // array[index++] = i;
            }
            if(count == target) {
                // result.add(array);
                int[] array = new int[hi - lo + 1];
                int l = lo;
                for(int i = 0; i < array.length; i++){
                    array[i] = l++;
                }
                result.add(array);
                lo++;
            }
            else if(count < target) hi++;
            else lo++;
        }

        int[][] last = new int[result.size()][];
        for(int i = 0; i < result.size(); i++){
            last[i] = result.get(i);
        }
        return last;
    }
}
