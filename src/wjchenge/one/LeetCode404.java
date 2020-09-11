package wjchenge.one;

/**
 * 404. 左叶子之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * @author wjchenge
 */
public class LeetCode404 {

    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        if (root.left != null && root.left.left == null && root.left.right == null) res = root.left.val;
        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
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
