package wjchenge.three;

/**
 * 543. 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @author wjchenge
 */
public class LeetCode543 {

    private int max;


    public int diameterOfBinaryTree(TreeNode root) {
        this.dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;

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
