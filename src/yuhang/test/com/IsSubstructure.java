package yuhang.test.com;

import com.sun.source.tree.Tree;

public class IsSubstructure {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(0);
        treeNode1.right = new TreeNode(1);
        treeNode1.left.left = new TreeNode(-4);
        treeNode1.left.right = new TreeNode(-3);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(-4);
        IsSubstructure isSubstructure = new IsSubstructure();
        System.out.println(isSubstructure.isSubStructure(treeNode1, treeNode2));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;

        boolean res = false;
        if (A.val == B.val) res = check(A.left, B.left) && check(A.right, B.right);
        if (!res) res = isSubStructure(A.left, B);
        if (!res) res = isSubStructure(A.right, B);

        return res;
    }
    public boolean check(TreeNode A, TreeNode B){
        if (B == null) return true;
        if (A == null) return false;
        boolean res = false;

        if (A.val == B.val){
            res = check(A.left, B.left) && check(A.right, B.right);
        }
        return res;
    }
}
