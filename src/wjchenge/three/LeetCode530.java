package wjchenge.three;

/**
 * 530. 二叉搜索树的最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * @author wjchenge
 */
public class LeetCode530 {

    private int pre = Integer.MAX_VALUE;

    private int min = Integer.MAX_VALUE;


    public int getMinimumDifference(TreeNode root) {
        this.inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre == Integer.MIN_VALUE) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        inOrder(root.right);
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
