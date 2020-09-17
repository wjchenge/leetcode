package wjchenge.one;

/**
 * 671. 二叉树中第二小的节点
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 * @author wjchenge
 */
public class LeetCode671 {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) return -1;
        int l = root.left.val;
        int r = root.right.val;
        if (l == root.val) {
            l = findSecondMinimumValue(root.left);
        }
        if (r == root.val) {
            r = findSecondMinimumValue(root.left);
        }

        if (l != r) return Math.min(l, r);
        if (l == -1) return r;
        return l;

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
