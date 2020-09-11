package wjchenge.one;

/**
 * 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author wjchenge
 */
public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(this.dfs(root.left) - this.dfs(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        return Math.max(this.dfs(root.left), this.dfs(root.right)) + 1;
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
