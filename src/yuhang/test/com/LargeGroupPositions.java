package yuhang.test.com;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {
    public static void main(String[] args) {
        String s = "aaa";
        LargeGroupPositions largeGroupPositions = new LargeGroupPositions();
        var result = largeGroupPositions.largeGroupPositions(s);
        for(List<Integer> item:result){
            System.out.print("[");
            for (var value:item){
                System.out.print(value + ", ");
            }
            System.out.println("]");
        }
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        int length = s.length();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> range = new ArrayList<>();
        int first = 0;
        int second = 1;
        for(; second < length; ++second){
            char c = s.charAt(second);
            if(s.charAt(first) != c) {
                if (second - first >= 3) {
                    range.add(first);
                    range.add(second - 1);
                    result.add(range);
                }
                range = new ArrayList<>();
                first = second;
            }
        }
        if(second - first >= 3){
            range = new ArrayList<>();
            range.add(first);
            range.add(second - 1);
            result.add(range);
        }
        return result;
    }
}
