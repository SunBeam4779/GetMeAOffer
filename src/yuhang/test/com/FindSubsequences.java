package yuhang.test.com;

import java.util.ArrayList;
import java.util.List;

public class FindSubsequences {
    public static void main(String[] args) {
        int[] data = {4, 2, 6, 7, 7};
        FindSubsequences findSubsequences = new FindSubsequences();
        var result= findSubsequences.findSubsequences(data);
        for (List<Integer> array:result){
            for (int item:array){
                System.out.print(item);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<List<List<Integer>>> record = new ArrayList<>();

        for(int i = 0; i < length; i++){
            record.add(i, new ArrayList<>(new ArrayList<>(nums[i])));
        }
//        record.get(0).add(new ArrayList<>(nums[0]));

        for(int i = 1; i < length; i++){
//            List<List<Integer>> temp = record.get(i);

            if(nums[i] < nums[i - 1]) continue;
            for (int index = 0; index < i; index++) {
                List<Integer> array = new ArrayList<>();
                List<List<Integer>> last = record.get(index);
                array.add(nums[index]);
                array.add(nums[i]);
                record.get(i).add(array);
                if(!last.isEmpty()) {
                    for (List<Integer> integers : last) {
                        array = new ArrayList<>(integers);
                        array.add(nums[i]);
                        record.get(i).add(array);
                    }
                }
            }
        }
        for(var arrays:record){
            for(var array:arrays){
                if(!res.contains(array) && array.size() > 1){
                    res.add(array);
                }
            }
        }
        return res;
    }
}
