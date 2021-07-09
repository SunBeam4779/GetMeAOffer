package yuhang.test.com;

import com.sun.source.tree.Tree;

public class KLargest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        KLargest kLargest = new KLargest();
        System.out.println(kLargest.kthLargest(root, 1));

        System.out.println(1 | 2 | 3);
    }
    int count = 0;
    int res;
    public int kthLargest(TreeNode root, int k) {
        find(root, k);
        return res;
    }

    public void find(TreeNode root, int k){
        if(root == null) return;

        if(count < k){
            find(root.right, k);
            count++;
            if(count == k) {
                res = root.val;
                return;
            }
            find(root.left, k);
        }
    }
}
