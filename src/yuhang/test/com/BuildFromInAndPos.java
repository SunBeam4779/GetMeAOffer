package yuhang.test.com;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class BuildFromInAndPos {
    public static void main(String[] args) {
        int[] in = {2, 1};
        int[] pos = {2, 1};
        BuildFromInAndPos buildFromInAndPos = new BuildFromInAndPos();
        TreeNode root = buildFromInAndPos.buildTree(in, pos);
        String s = "";
        System.out.println(s.length() == 0);
    }
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 && postorder.length == 0) return null;
        this.inorder = inorder;
        this.postorder = postorder;
        return process(0, inorder.length - 1, 0, postorder.length - 1);
    }
    public TreeNode process(int inLeft, int inRight, int posLeft, int posRight){
        if(posLeft == posRight) return new TreeNode(postorder[posLeft]);
        TreeNode root = new TreeNode(postorder[posRight]);
        int inRoot = 0;
        for(int i = inLeft; i <= inRight; ++i){
            if(inorder[i] == postorder[posRight]){
                inRoot = i;
                break;
            }
        }
        if(inRoot != inLeft) root.left = process(inLeft, inRoot - 1, posLeft, posLeft + inRoot - inLeft - 1);
        if(inRoot != inRight) root.right = process(inRoot + 1, inRight, posLeft + inRoot - inLeft, posRight - 1);
        return root;
    }
}
