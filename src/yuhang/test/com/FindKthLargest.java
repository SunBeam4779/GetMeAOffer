package yuhang.test.com;

public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest.findKthLargest(nums, k));
    }
    public int findKthLargest(int[] nums, int k) {
        return sort(nums, 0, nums.length - 1, k);
    }

    public int sort(int[] data, int lo, int hi, int k){
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        int val  = data[lo];
        while(i <= gt){
            int cmp = data[i];
            if(cmp < val){
                data[i++] = val;
                data[lt++] = cmp;
            }else if(cmp > val){
                data[i] = data[gt];
                data[gt--] = cmp;
            }else{
                i++;
            }
        }
        int res = 0;
        if(lt <= data.length - k && data.length - k <= gt) res = data[data.length - k];
        else if(data.length - k < lt){
            res = sort(data, lo, lt - 1, k);
        }else{
            res = sort(data, gt + 1, hi, k);
        }
        return res;
    }
}
