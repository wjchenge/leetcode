package wjchenge.one;

/**
 * 563. 二叉树的坡度
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 * @author wjchenge
 */
public class LeetCode563 {

    private int sum = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        this.dfs(root);
        return sum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        sum += Math.abs(l - r);
        return l + r + root.val;
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
