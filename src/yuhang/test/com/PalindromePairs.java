package yuhang.test.com;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {
    public static void main(String[] args) {
        PalindromePairs palindromePairs = new PalindromePairs();
        String[] strings = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> lists = palindromePairs.palindromePairs(strings);
        for (List<Integer> item: lists){
            for (Object i:item){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        boolean pair = true;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> container;
        for (int i = 0; i < words.length; i++){
            String temp;
            container = new ArrayList<>();
            container.add(i);
            for (int j = 0; j < words.length; j++ ){
                if (j == i) continue;
                if(!words[i].equals("") && !words[j].equals(""))
                    if(words[i].charAt(0) != words[j].charAt(words[j].length() - 1))
                        continue;
                temp = words[i] + words[j];
                int length = temp.length();

                for (int index = 0; index < length / 2; index++){
                    if (temp.charAt(index) != temp.charAt(length - index - 1)){
                        pair = false;
                        break;
                    }
                }
                if (pair) {
                    container.add(j);

                    result.add(container);
//                    pair = true;
                    container = new ArrayList<>();
                    container.add(i);
                }
                pair = true;
            }
        }
        return result;
    }
}
