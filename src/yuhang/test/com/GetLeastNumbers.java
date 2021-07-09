package yuhang.test.com;

public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] data = {3, 2, 1};
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] res = getLeastNumbers.getLeastNumbers(data, 2);
        for (int item:res){
            System.out.println(item);
        }
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        int index = partition(arr, 0, arr.length - 1);
        while(index != k){
            if(index < k){
                index = partition(arr, index + 1, arr.length - 1);
            }
            if(index > k){
                index = partition(arr, 0, index - 1);
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = arr[i];
        }
        return res;
    }
    public int partition(int[] data, int lo, int hi){
        if(lo >= hi) return lo;
        int value = data[lo];
        int i = lo + 1;
        int j = hi;
        while(i < j){
            while(data[i] <= value && i < hi) i++;
            while(data[j] > value && j > lo) j--;
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
        data[lo] = data[i];
        data[i] = value;
        return i;
    }
}
