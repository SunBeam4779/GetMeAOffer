package yuhang.test.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
public class ByteDanceDemo1{
    static int doubleCard;
    static boolean four;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for(int index = 0; index < num; index++){
            int length = scanner.nextInt();
            List<List<String>> frames = new ArrayList<>(length);
            for(int i = 0; i < length; i++){
                int count = scanner.nextInt();
                ArrayList<String> arrayList = new ArrayList<>();
                for(int j = 0; j < count; j++){
                    String first = String.valueOf(scanner.nextInt());
                    String second = String.valueOf(scanner.nextInt());
                    arrayList.add(first + second);
                }
                frames.add(arrayList);
            }
            int result = solution(frames);
            System.out.println(result);
        }
    }
    public static int solution(List<List<String>> list){
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < list.get(0).size(); i++){
            hashMap.put(list.get(0).get(i), 1);
        }
        list.remove(0);
        int max = 1;
        for(List<String> item:list){
            HashMap<String, Integer> temp = new HashMap<>();;
            for(String s:item){
                if (hashMap.containsKey(s)){
                    int count = hashMap.get(s);
                    temp.put(s, count + 1);
                    if(count + 1 > max) max = count;
                }else{
                    temp.put(s, 1);
                }
            }
            hashMap = temp;
        }
        return max;
    }
}