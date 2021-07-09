package yuhang.test.com;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] data = new int[]{1, 3, 1, 2, 0, 5};
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] result = maxSlidingWindow.maxSlidingWindow(data, 3);
        for (int item: result){
            System.out.println(item);
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return nums;
        int out_;
        int in_;
        int max = nums[0];
        int length = nums.length - k + 1;
        int[] result = new int[length];
        for(int i = 1; i < k; i++){
            if(nums[i] > max) max = nums[i];
        }
        result[0] = max;
        for(int i = 1; i < length; i++){
            out_ = nums[i - 1];
            in_ = nums[i + k - 1];
            if(out_ != max && in_ <= max) result[i] = max;
            if(out_ != max && in_ > max) {
                result[i] = in_;
                max = in_;
            }
            if(out_ == max && in_ >= max){
                result[i] = in_;
                max = in_;
            }
            if(out_ == max && in_ < max){
                max = in_;
                for(int index = i; index <= i + k - 2; index++){
                    if(nums[index] > max) max = nums[index];
                }
                result[i] = max;
            }
        }
        return result;
    }
}
