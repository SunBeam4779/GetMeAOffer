package yuhang.test.com;

import java.util.LinkedList;

public class LastRemaining {
    public static void main(String[] args) {
        LastRemaining lastRemaining = new LastRemaining();
        System.out.println(lastRemaining.lastRemaining(9, 13));
    }

    public int lastRemaining(int n, int m) {
        LinkedList<Integer> link = new LinkedList<>();
        for(int i = 0; i < n; i++){
            link.add(i);
        }
        int start = 0;
        while(link.size() >1){

            start = (start + m - 1) % link.size();
            link.remove(start);

        }
        return link.get(0);
    }

}


