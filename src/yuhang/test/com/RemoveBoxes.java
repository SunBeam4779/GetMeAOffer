package yuhang.test.com;

import java.util.HashMap;

/**
 * Bad code! this code can't run correctly.
 */

public class RemoveBoxes {
    public static void main(String[] args) {
        int[] data = new int[]{1, 3, 2, 2, 2, 4, 1};
        System.out.println(new RemoveBoxes().removeBoxes(data));
    }
    int count = 0;
    int index = 0;
    int num = 0;
    int size;
    HashMap<Integer, Integer> hashMap;
    public int removeBoxes(int[] boxes){
        size = boxes.length;
        hashMap = new HashMap<>();
        int[] record = new int[boxes.length];

        record[0] = 1;

        for (int i = 1; i < boxes.length; i++){
            hashMap.put(boxes[i], hashMap.get(boxes[i]) + 1);
            if(boxes[i] == boxes[i - 1])
                record[i] = 1 + record[i - 1];
            else record[i] = 1;
            if (count < record[i]){
                count = record[i];
                index = i;
            }
        }
        num = boxes[index];
        return process(boxes, record);
    }

    public int process(int[] boxes, int[] record){
        if (size == 0) return 0;
        int res = 0;
        res = count * count;
        int length = count;
        size -= count;
        count = 0;

        if(boxes[index - length] == boxes[index + 1] && index - length >= 0 && index < boxes.length - 1){
            int temp = record[index - length];
            int val = boxes[index - length];

            for (int i = index - length + 1; i < boxes.length; i++){
                if (boxes[i] == num) {
                    boxes[i] = 0;
                    record[i] = 0;
                }
                if (boxes[i] == val) {
                    record[i] = record[i] + temp;
                }
            }
        }else{
            for (int i = index - length + 1; i < index; i++){
                if (boxes[i] == num) {
                    boxes[i] = 0;
                    record[i] = 0;
                }
            }
        }
        for (int i = 0; i < boxes.length; i++){
            if (count < record[i]){
                count = record[i];
                index = i;
            }
        }
        int co = 100;
        if (count == 1){

            for (int i = 0; i < boxes.length; i++){
                if(hashMap.get(boxes[i]) < co) {
                    co = hashMap.get(boxes[i]);
                    index = i;
                }
            }
        }
        res += process(boxes, record);
        return res;
    }
}
