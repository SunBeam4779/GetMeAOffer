package yuhang.test.com;

import java.util.*;

public class Ctrip2 {
    final static String CIRCLE = "--circular dependency";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = "a bc d eag f"; // scanner.nextLine();
        String[] point = string.split(" ");
        Queue<String> res = new Ctrip2().solution(point);
        for (String item:res){
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < item.length(); i++){
                set.add(item.charAt(i));
            }
            if (set.size() == item.length()) System.out.println(item);
            else System.out.println(item + CIRCLE);
        }
    }

    public Queue<String> solution(String[] points){
        Queue<String> res = new LinkedList<>();
        if(points[0].length() > 1){
            for (int i = 0; i < points.length; i++){
                res.add(String.valueOf(points[0].charAt(i)));
            }
        }else{
            res.add(points[0]);
        }
        for (int i = 1; i < points.length; i++){
            String temp = points[i];
            if (temp.length() > 1){
                Queue<String> record = new LinkedList<>();
                for (int j = 0; j < temp.length(); j++){
                    for (int k = 0; k < res.size(); k++){
                        String s = res.poll();
                        record.offer(s + temp.charAt(j));
                        res.offer(s);
                    }
                }
                res = record;
            }
            else{
                for (int j = 0; j < res.size(); j++){
                    res.offer(res.poll() + temp);
                }
            }
        }
        return res;
    }
}
