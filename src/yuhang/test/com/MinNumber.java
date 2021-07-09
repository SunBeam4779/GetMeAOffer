package yuhang.test.com;

public class MinNumber {
    public static void main(String[] args) {
        int[] value = {10, 2};
        MinNumber minNumber = new MinNumber();

        String res = minNumber.minNumber(value);
        System.out.println(res);
    }

    public String minNumber(int[] nums) {
        String[] data = new String[nums.length];
        for(int i = 0; i < data.length; i++){
            data[i] = String.valueOf(nums[i]);
        }
        sort(data, 0, data.length - 1);
        StringBuilder res = new StringBuilder();
        for(String item:data){
            res.append(item);
        }
        return res.toString();
    }
    public void sort(String[] data, int lo, int hi){
        if(lo >= hi) return;
        int i = lo;
        int j = hi;
        String change = data[lo];
        while(i < j){
            while((data[i] + data[lo]).compareTo(data[lo] + data[i]) <= 0 && i < j) i++;
            while((data[lo] + data[j]).compareTo(data[j] + data[lo]) <= 0 && j > i) j--;

            change = data[i];
            data[i] = data[j];
            data[j] = change;
        }
        data[i] = data[lo];
        data[lo] = change;

        sort(data, lo, i - 1);
        sort(data, i + 1, hi);
    }
}
