package yuhang.test.com;

import java.util.*;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> result = levelOrder.levelOrder(root);
        for(List<Integer> arr:result){
            for (int item:arr){
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
    Deque<TreeNode> queue1 = new LinkedList<>();
    Deque<TreeNode> queue2 = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    boolean even;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return result;
        queue1.offer(root);

        while(!queue1.isEmpty() || !queue2.isEmpty()){
            int size;
            List<Integer> list = new ArrayList<>();
            if(even){
                size = queue2.size();
                for(int i = size - 1; i >= 0; i--){
                    TreeNode temp = queue2.pollLast();
                    list.add(temp.val);
                    if(temp.right != null) queue1.offerFirst(temp.right);
                    if(temp.left != null) queue1.offerFirst(temp.left);

                }
            }
            else{
                size = queue1.size();
                for(int i = size - 1; i >= 0; i--){
                    TreeNode temp = queue1.pollFirst();

                    list.add(temp.val);

                    if(temp.left != null) queue2.offerLast(temp.left);
                    if(temp.right != null) queue2.offerLast(temp.right);
                }
            }
            result.add(list);
            even = !even;
        }
        return result;
    }
}
