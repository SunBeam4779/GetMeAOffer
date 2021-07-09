package yuhang.test.com;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483647,2147483647};
        SummaryRanges summaryRanges = new SummaryRanges();
        var newdata = nums;
        for(var item : newdata){
            System.out.println(item);
        }
        var result = summaryRanges.summaryRanges(nums);
        for (var item:result
             ) {
            System.out.println(item);
        }
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        StringBuffer string = new StringBuffer();
        long first = nums[0];
        long last = first;
        for(int i = 1; i < nums.length; ++i){
            long temp = nums[i];
            long dist = temp - last;
            if(dist > 1){
                string.append(first);
                if(last != first){
                    string.append("->");
                    string.append(last);
                }
                result.add(string.toString());
                string = new StringBuffer();
                first = temp;
            }
            last = temp;
        }
        string.append(first);
        if(last != first){
            string.append("->");
            string.append(last);
        }
        result.add(string.toString());
        return result;
    }
}
