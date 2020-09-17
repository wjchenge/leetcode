package wjchenge.one;

/**
 * 687. 最长同值路径
 * https://leetcode-cn.com/problems/longest-univalue-path/
 * @author wjchenge
 */
public class LeetCode687 {

    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        this.helper(root, root.val);
        this.longestUnivaluePath(root.left);
        this.longestUnivaluePath(root.right);
        return max;

    }

    private int helper(TreeNode root, int val) {
        if (root == null || root.val != val) return 0;
        int l = helper(root.left, val);
        int r = helper(root.right, val);
        max = Math.max(l + r, max);
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
