package yuhang.test.com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> result = partitionLabels.partitionLabels(s);
        for(Integer item:result){
            System.out.println(item);
        }
    }

    public List<Integer> partitionLabels(String S) {
        int length = S.length();
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        for(int i = 1; i < length; ++i){
            // char c = S.charAt(i);
            Queue<Integer> record = new LinkedList<>();
            int head = 0;
            while(!queue.isEmpty()){
                int tail = queue.poll();
                if(S.substring(head, tail).contains(S.substring(i, i + 1))) break;
                else{
                    record.offer(tail);
                    head = tail;
                }
            }
            queue = record;
            queue.offer(i + 1);
        }
        int start = 0;
        while(!queue.isEmpty()){
            int end = queue.poll();
            result.add(end - start);
            start = end;
        }
        return result;
    }
}
