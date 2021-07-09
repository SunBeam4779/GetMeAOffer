package yuhang.test.com;

import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(674);
        maxQueue.push_back(770);
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(525);
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(425);
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(720);
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(373);
        maxQueue.push_back(411);
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(831);
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(765);
        maxQueue.push_back(701);
        System.out.println(maxQueue.pop_front());
    }
    Queue<Integer> queue;
    int max;
    int second;
    public MaxQueue() {
        queue = new LinkedList<>();
        this.max = -1;
        this.second = -1;
    }

    public int max_value() {
        return max;
    }

    public void push_back(int value) {
        if(queue.isEmpty()){
            this.max = value;
            this.second = -1;
            queue.offer(value);
        }else {
            queue.offer(value);
            if (value > max) {
                max = value;
                second = -1;
            } else {
                if (value > second) second = value;
            }
        }
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        int value = queue.poll();
        if(value == this.max){
            this.max = second;
            this.second = -1;
        }
        return value;
    }
}
