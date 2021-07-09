package yuhang.test.com;

import java.util.*;

public class stickCalculator {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int length = scanner.nextInt();
//        List<List<Integer>> arrays = new ArrayList<>();
//        while(scanner.hasNext()){
//            ArrayList<Integer> array = new ArrayList<>(length);
//            for (int i = 0; i < length; i++){
//                array.add(scanner.nextInt());
//            }
//            arrays.add(array);
//            length = scanner.nextInt();
//            if(length == 0) break;
//        }
        List<List<Integer>> in = new LinkedList<>();
        ArrayList<int[]> arraylist = new ArrayList<>();


        int[] array1 = new int[]{5,2 ,1, 5, 2, 1, 5, 2, 1};
        int[] array2 = new int[]{1, 2, 3, 4};
        arraylist.add(array1);
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> arrayList2 = new ArrayList<>();
        for (int item: array1){
            arrayList.add(item);
        }
        for (int item: array2){
            arrayList2.add(item);
        }
        in.add(arrayList);
        in.add(arrayList2);
        int[] res = new stickCalculator().solution(in);
        for (int item: res){
            System.out.println(item);
        }
    }
    public int[] solution(List<List<Integer>> arrays){
        int[] res = new int[arrays.size()];
        int i = 0;
        for(List<Integer> item: arrays){
            int total = 0;
            for (int val:item){
                total += val;
            }
            int sum = item.size() - 1;
            int min = 51;
            while(sum > 1){

                if(item.size() % sum == 0){
//                    if(process(item, sum, total) && min > sum)
                    min = sum;
                }
                sum--;
            }
            res[i++] = min;
        }
        return res;
    }

//    public boolean process(List<Integer> data, int sum, int total){
//        int length = data.size();
//        int each = total / sum;
//        int min = 51;
//        for(int i = 0; i < length; i++){
//
//        }
//        return min;
//    }
}
