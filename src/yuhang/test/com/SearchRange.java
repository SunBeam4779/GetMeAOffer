package yuhang.test.com;

public class SearchRange {
    public static void main(String[] args) {
        int[] value = {5, 7, 7, 8, 8, 10};
        int target = 8;
        var search = new SearchRange();
        var result = search.searchRange(value, target);
        System.out.println(result[0] + ", " + result[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int hi = length - 1;
        int lo = 0;
        while(hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                int start = mid;
                int stop = mid;
                while (nums[start] == target) {
                    if (start == 0) break;
                    start--;
                }
                while (nums[stop] == target) {
                    if (stop == length - 1) break;
                    stop++;
                }
                int first;
                int second;
                if (nums[start] == target)
                    first = start;
                else
                    first = start + 1;
                if (nums[stop] == target)
                    second = stop;
                else
                    second = stop - 1;
                return new int[]{first, second};
            }
        }
        return new int[]{-1, -1};
    }
}
