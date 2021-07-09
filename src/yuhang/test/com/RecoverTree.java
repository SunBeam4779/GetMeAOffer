package yuhang.test.com;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class RecoverTree {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(1);
        TreeNode tree = new TreeNode(2, left, right);
        RecoverTree recoverTree = new RecoverTree();
        recoverTree.recoverTree(tree);
        List<Integer> list = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

    }
    int wrongLeft;
    int wrongRight;
    public void recoverTree(TreeNode root) {
        int val = root.val;
        boolean leftOrder = less(root.left, val);
        boolean rightOrder = bigger(root.right, val);

//        if(leftOrder && rightOrder){
//            recoverTree(root.left);
//            recoverTree(root.right);
//        }else if(leftOrder){
//            recoverTree(root.right);
//        }else if(rightOrder){
//            recoverTree(root.left);
//        }else{
//
//        }
        if (less(root.left, val)){
            if (bigger(root.right, val)){
                recoverTree(root.left);
            }
            recoverTree(root.right);
        }else{
            if (bigger(root.right, val)){
                recoverTree(root.left);
            }else{

            }
        }

    }

    public boolean less(TreeNode node, int val){
        if(node == null) return true;
        if(node.val < val) {
            return less(node.left, val) && less(node.right, val);
        }
        wrongLeft = node.val;
        node.val = val;
        return false;
    }

    public boolean bigger(TreeNode node, int val){
        if(node == null) return true;
        if(node.val > val){
            return bigger(node.left, val) && bigger(node.right, val);
        }
        wrongRight = node.val;
        node.val = val;
        return false;
    }
}