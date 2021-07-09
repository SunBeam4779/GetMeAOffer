package yuhang.test.com;

import java.util.HashMap;
import java.util.Random;

public class RandomListCopy {
    public static void main(String[] args) {
        RandomNode head = new RandomNode(7);
        String s = "I love you,yuo";
        String[] re = s.split("[ |,|.|\\?|!|]");
        for (var item: re){
            System.out.println(item);
        }
    }
    public RandomNode copyRandomList(RandomNode head) {
        HashMap<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode temp = head;
        RandomNode res = new RandomNode(head.val);
        RandomNode nextNode = res;
        RandomNode randomOfres = res;
        while(temp != null){
            RandomNode node = new RandomNode(temp.val);
            map.put(temp, node);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            nextNode.next = map.get(temp.next);
            nextNode = nextNode.next;
            randomOfres.random = map.get(temp.random);
            randomOfres = randomOfres.next;
            temp = temp.next;
        }
        return res;
    }
}

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}