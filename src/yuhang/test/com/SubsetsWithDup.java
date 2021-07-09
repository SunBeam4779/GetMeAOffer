package yuhang.test.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsWithDup {
    public static void main(String[] args) {
        int[] arrays = new int[]{1, 2, 2};
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        var result = subsetsWithDup.subsetsWithDup(arrays);
        for(var array : result){
            for(var item: array){
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
    List<Integer> array = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    HashSet<List<Integer>> temp = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        for(int i = 0; i < nums.length; ++i){
            array.clear();
            array.add(nums[i]);
            dfs(array, nums, i);
        }
        return result;
    }

    public void dfs(List<Integer> array, int[] nums, int index){
        if(!temp.contains(array)){
            temp.add(new ArrayList<>(array));
            result.add(new ArrayList<>(array));
        }
        for(int i = index + 1; i < nums.length; ++i){
            array.add(nums[i]);
            dfs(array, nums, i);
            array.remove(array.size() - 1);
        }
    }
}
