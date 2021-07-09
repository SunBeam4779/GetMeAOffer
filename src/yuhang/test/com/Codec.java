package yuhang.test.com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec codec = new Codec();
        String serial = codec.serialize(root);
        System.out.println(serial);
        TreeNode res = codec.deserialize(serial);
    }
    Queue<TreeNode> queue;
    Queue<TreeNode> tree;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        queue = new LinkedList<>();
        if (root == null) return "[]";
        StringBuilder result = new StringBuilder("[");
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(temp != null) {
                    result.append(temp.val).append(",");

                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
                else{
                    result.append("null,");
                }
            }
        }
        result.deleteCharAt(result.length() - 1);
        result.append("]");
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        tree = new LinkedList<>();
        if(data.equals("[]")) return null;
        String substring = data.substring(1, data.length() - 1);
        String[] node = substring.split(",");
        int index = 1;
        TreeNode ans = new TreeNode(Integer.parseInt(node[0]));
        tree.offer(ans);
        while(!tree.isEmpty()){
            TreeNode temp = tree.poll();
            if(!node[index].equals("null")){
                temp.left = new TreeNode(Integer.parseInt(node[index++].trim()));
                queue.offer(temp.left);
            }
            if(!node[index].equals("null")){
                temp.right = new TreeNode(Integer.parseInt(node[index++].trim()));
                queue.offer(temp.right);
            }
        }
        return ans;
    }
}
