package yuhang.test.com;

public class SearchNum {
    public static void main(String[] args) {
        int[] data = new int[]{5, 7, 7, 8, 8, 10};
        SearchNum searchNum = new SearchNum();
        System.out.println(searchNum.search(data, 8));
    }
    public int search(int[] nums, int target) {
        int index = searchFirst(nums, 0, nums.length - 1, target);
        if(index == -1) return 0;
        int index2 = searchLast(nums, 0, nums.length - 1, target);

        return index2 - index + 1;
    }
    public int searchFirst(int[] nums, int lo, int hi, int target){
        if(lo > hi) return -1;
        // int res = 0;
        int mid = (hi - lo) / 2 + lo;
        // if(target == nums[mid]) res = mid;
        if(target > nums[mid]) lo = mid + 1;
        else if(target < nums[mid]) hi = mid - 1;
        else {
            if (mid == 0 || nums[mid - 1] != target) return mid;
            else
                hi = mid - 1;
        }
        return searchFirst(nums, lo, hi, target);
    }

    public int searchLast(int[] nums, int lo, int hi, int target){
        if(lo > hi) return -1;
        // int res = 0;
        int mid = (hi - lo) / 2 + lo;
        // if(target == nums[mid]) res = mid;
        if(target > nums[mid]) lo = mid + 1;
        else if(target < nums[mid]) hi = mid - 1;
        else {
            if (mid == nums.length - 1 || mid < nums.length - 1 && nums[mid + 1] != target) return mid;
            else
                lo = mid + 1;
        }
        return searchLast(nums, lo, hi, target);
    }
}
