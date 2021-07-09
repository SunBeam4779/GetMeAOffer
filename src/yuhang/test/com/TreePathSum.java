package yuhang.test.com;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(9);
        root.right = new TreeNode(-6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        TreePathSum treePathSum = new TreePathSum();
        List<List<Integer>> result = treePathSum.pathSum(root, 7);
        for(List<Integer> array:result){
            for (int item:array){
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
    List<List<Integer>> result = new ArrayList<>();
    int value;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        value = sum;
        List<Integer> record = new ArrayList<>();
        if(root == null) return result;

        record.add(root.val);
        if(root.val == sum && root.left == null && root.right == null){
            result.add(record);
            return result;
        }
        process(root, record, root.val);
        // process(root.right, record, root.val);
        return result;
    }

    public void process(TreeNode root, List<Integer> list, int val){
        if(root.left == null && root.right == null && val == value){
            result.add(list);
            return;
        }
        int leftVal = 0;
        int rightVal = 0;
        if(root.left != null) leftVal = root.left.val;
        if(root.right != null) rightVal = root.right.val;

        if(root.left != null){
            List<Integer> temp = new ArrayList<>(list);
            temp.add(leftVal);
            process(root.left, temp, val + leftVal);
        }
        if(root.right != null){
            List<Integer> temp1 = new ArrayList<>(list);
            temp1.add(rightVal);
            process(root.right, temp1, val + rightVal);
        }
    }
}
