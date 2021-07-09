package yuhang.test.com;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        String data = "abc";
        Permutation permutation = new Permutation();

//        String[] result = permutation.permutation(data);
//        for (String item:result){
//            System.out.println(item);
//
//        }
        System.out.println(permutation.getPermutation(3, 3));
    }
    HashSet<String> result;
    char[] letter;
    ArrayList<Integer> result1;
    boolean[] mark;
    int length;
    int Kth;
    public String getPermutation(int n, int k) {
        length = n;
        Kth = k;
        result1 = new ArrayList<>();
        ArrayList<Integer> data = new ArrayList<>();
        for(int i = 0; i < n; i++){
            data.add(i + 1);
        }
        mark = new boolean[n];
        process(data, 0, 0, 0);
        return String.valueOf(result1.get(k - 1));
    }

    public void process(ArrayList<Integer> data, int num, int pos, int index){
        ArrayList<Integer> number = new ArrayList<>(data);
        if(pos != 0) number.remove(index);
        if(number.size() == 0){
            result1.add(num);
            return;
        }

        for(int i = 0; i < number.size(); i++){
//            if(mark[i]) continue;
            int temp = num * 10 + number.get(i);

            process(number, temp, pos + 1, i);
//            mark[i] = false;
            if(result1.size() == Kth) break;
        }
    }
    public String[] permutation(String s) {
        result = new HashSet<>();
        letter = s.toCharArray();
        char[] string = new char[letter.length];
        boolean[] marked = new boolean[s.length()];
        process(string, marked, 0);

        String[] res = new String[result.size()];
        Iterator<String> iterator = result.iterator();
        int i = 0;
        while(iterator.hasNext()){
            res[i++] = iterator.next();
        }
        return res;
    }
    public void process(char[] string, boolean[] marked, int index){
        if(index == letter.length){
            String temp = String.valueOf(string);

            result.add(temp);
            return;
        }

        for(int i = 0; i < letter.length; i++){
            if(marked[i]) continue;
            string[index] = letter[i];
            marked[i] = true;
            process(string, marked, index + 1);
            string[index] = ' ';
            marked[i] = false;
        }
    }
}
