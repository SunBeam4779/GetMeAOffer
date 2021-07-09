package yuhang.test.com;

import java.util.Stack;

public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        MergeTwoArrays mergeTwoArrays = new MergeTwoArrays();
        mergeTwoArrays.merge(nums1, 3, nums2, 3);
        for (int item: nums1){
            System.out.println(item);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int[] nums = new int[m + n];
        while(index1 < m || index2 < n){
            if(index1 < m && index2 < n){
                if(nums1[index1] <= nums2[index2]){
                    nums[index++] = nums1[index1++];
                }
                else{
                    nums[index++] = nums2[index2++];
                }
            }
            else{
                if(index1 == m){
                    nums[index++] = nums2[index2++];
                }
                else if(index2 == n){
                    nums[index++] = nums1[index1++];
                }
            }
        }
        System.arraycopy(nums, 0, nums1, 0, m + n);
    }
}
