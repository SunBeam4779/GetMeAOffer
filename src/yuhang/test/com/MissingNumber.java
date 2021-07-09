package yuhang.test.com;

public class MissingNumber {
    public static void main(String[] args) {
        int[] data = new int[]{1};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(data));
    }
    public int missingNumber(int[] nums) {
        // if(nums.length == 1 && nums[0] == 0) return 1;
        if(nums.length == 0) return 0;
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int lo, int hi){
        if(lo == nums.length) return nums.length;
        if(lo > hi) return -1;
        int mid = (hi - lo) / 2 + lo;

        if(mid == nums[mid]) lo = mid + 1;
        else{
            if(mid == 0 || nums[mid - 1] == mid - 1) return mid;
            else hi = mid - 1;
        }
        return search(nums, lo, hi);
    }
}
