package yuhang.test.com;

import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 2};
        int[] res = intersection.intersection(nums1, nums2);
        for(int item:res){
            System.out.println(item);
        }
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int j : nums1) {
            set.add(j);
        }
        for (int j : nums2) {
            if (set.contains(j)) {
                result.add(j);
            }
        }
        int size = result.size();
        int[] ans = new int[size];
        Iterator<Integer> iterator = result.iterator();
        int i = 0;
        while(iterator.hasNext()){
            ans[i++] = iterator.next();
        }
        return ans;
    }
}
