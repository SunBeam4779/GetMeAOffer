package yuhang.test.com;

import java.util.Arrays;

public class IsStraight {
    public static void main(String[] args) {
        int[] data = new int[]{0, 0, 1, 2, 5};
        IsStraight isStraight = new IsStraight();
        System.out.println(isStraight.isStraight(data));
    }
    public boolean isStraight(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0){
                count++;
                continue;
            }
            if(nums[i] == nums[i + 1]) return false;
            if(nums[i] + 1 < nums[i + 1]){
                int val = nums[i + 1] - nums[i] - 1;
                if(val <= count){
                    count -= val;
                }else
                    return false;
            }
        }
        return true;
    }
}
