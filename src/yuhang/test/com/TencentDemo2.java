package yuhang.test.com;

import java.lang.reflect.Array;
import java.util.*;

public class TencentDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NumOfPeople = scanner.nextInt();
        int group = scanner.nextInt();
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        for(int i = 0; i < group; i++){
            ArrayList<Integer> temp = new ArrayList<>();

            int length = scanner.nextInt();
            for (int j = 0; j < length; j++){
                temp.add(scanner.nextInt());
            }
            data.add(temp);
        }
        System.out.print(process(data));
    }
    public static int process(ArrayList<ArrayList<Integer>> data){
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int size = data.size();
        boolean[] mark = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (data.get(i).contains(0)) {
                set.addAll(data.get(i));
                queue.addAll(data.get(i));
                mark[i] = true;
            }
        }
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for (int i = 0; i < size; i++){
                if (!mark[i] && data.get(i).contains(temp)) {
                    set.addAll(data.get(i));
                    queue.addAll(data.get(i));
                    mark[i] = true;
                }
            }
        }
        return set.size();
    }
}
