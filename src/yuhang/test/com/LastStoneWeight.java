package yuhang.test.com;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        var lastStoneWeight = new LastStoneWeight();
        var value = lastStoneWeight.lastStoneWeight(stones);
        System.out.println(value);
    }

    public int lastStoneWeight(int[] stones) {
        int length = stones.length;
        Queue<Integer> priorityQueue = new PriorityQueue<>(length, (o1, o2) -> o2 - o1);

        for (int stone : stones) {
            priorityQueue.offer(stone);
        }
        while(priorityQueue.size() > 1){
            int larger = priorityQueue.poll();
            int less = 0;
            if (priorityQueue.size() > 0)
                less = priorityQueue.poll();
            if(larger > less){
                priorityQueue.offer(larger - less);
            }
        }
        if(priorityQueue.size() == 0) return 0;
        else return priorityQueue.poll();
    }
}
