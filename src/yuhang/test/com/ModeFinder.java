package yuhang.test.com;

import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class ModeFinder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.left = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);
        ModeFinder modeFinder = new ModeFinder();
        var res = modeFinder.findMode(root);
        for(int item:res){
            System.out.println(item);
        }
    }
    Stack<Integer> stack = new Stack<>();
    int max;
    ArrayList<Integer> array = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        max = 1;
        process(root);
        array.add(-1);
        int count = 1;
        for(int i = 1; i < array.size(); i++){
            if(array.get(i).equals(array.get(i - 1))){
                count++;
            }else{
                if(max < count) {
                    max = count;

                    stack.clear();
                    stack.push(i - 1);
                }else if(max == count){

                    stack.push(i - 1);
                }
                count = 1;
            }
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            res[i] = array.get(stack.pop());
            i++;
        }
        return res;
    }

    public void process(TreeNode root){
        if(root == null) return;
        process(root.left);
        array.add(root.val);
        process(root.right);
    }
}
