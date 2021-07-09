package yuhang.test.com;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        int res = sumOfLeftLeaves.sumOfLeftLeaves(root);
        System.out.println(res);
    }

    int count;
    public int sumOfLeftLeaves(TreeNode root) {
        count = 0;
        process(root);
        return count;
    }
    public void process(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            count += root.val;
            return;
        }

        process(root.left);
        if(root.right.left == null && root.right.left == null) return;
        else{
            process(root.right);
        }
    }
}
