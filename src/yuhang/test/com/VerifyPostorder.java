package yuhang.test.com;

import java.util.ArrayList;

public class VerifyPostorder {
    public static void main(String[] args) {
        int[] root  = {1, 2, 5, 10, 6, 9, 4, 3};
        VerifyPostorder verifyPostorder = new VerifyPostorder();
        System.out.println(verifyPostorder.verifyPostorder(root));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        ArrayList<Integer> arrayList = new ArrayList<>(list);
        arrayList.add(1);
        System.out.println(list.size());
        System.out.println(arrayList.size());
    }
    public boolean verifyPostorder(int[] postorder) {
        int length = postorder.length;
        if(length == 0) return true;
        return verifyPostorder(postorder, 0, length - 1);
    }
    public boolean verifyPostorder(int[] postorder, int lo, int hi){
        if(lo >= hi) return true;
        int indexLeft = lo - 1;
        for(int i = lo; i < hi; i++){
            if(postorder[i] > postorder[hi]){
                break;
            }
            indexLeft++;
        }
        for(int i = indexLeft + 1; i < hi; i++){
            if(postorder[i] < postorder[hi]) return false;
        }
        return verifyPostorder(postorder, lo, indexLeft) && verifyPostorder(postorder, indexLeft + 1, hi - 1);
    }
}
