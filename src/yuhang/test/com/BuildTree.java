package yuhang.test.com;

import java.util.Arrays;

public class BuildTree {
    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree.buildTree(pre, in);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 && inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int pos = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                pos = i;
                break;
            }
        }
//        int[] preleft = new int[pos];
//        int[] inleft = new int[pos];
//        for(int i = 0; i < pos; i++){
//            preleft[i] = preorder[i + 1];
//            inleft[i] = inorder[i];
//        }
//        int[] preright = new int[inorder.length - pos - 1];
//        int[] inright = new int[inorder.length - pos - 1];
//        for(int i = 0; i < inorder.length - pos - 1; i++){
//            preright[i] = preorder[pos + 1 + i];
//            inright[i] = inorder[i + pos + 1];
//        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, pos + 1), Arrays.copyOfRange(inorder, 0, pos));
        root.right = buildTree(Arrays.copyOfRange(preorder, pos + 1, preorder.length), Arrays.copyOfRange(inorder, pos + 1, inorder.length));
//        root.left = buildTree(preleft, inleft);
//        root.right = buildTree(preright, inright);
        return root;
    }
}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}