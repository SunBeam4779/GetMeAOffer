package yuhang.test.com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        var combination = new Combination();
        var result = combination.combine(4, 2);
        for(var list:result){
            for (var item:list){
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
    List<List<Integer>> result;
    int N;
    int K;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        N = n;
        K = k;
        process(new LinkedList<>(), 1);
        return result;
    }

    public void process(LinkedList<Integer> record, int index){
        if(record.size() == K){
            result.add(new LinkedList<>(record));
            return;
        }
        for(int i = index; i <= N; i++){
            record.addLast(i);
            process(record, i + 1);
            record.removeLast();
        }
    }
}
