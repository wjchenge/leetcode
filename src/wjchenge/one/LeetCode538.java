package wjchenge.one;

/**
 * 501. 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * @author wjchenge
 */
public class LeetCode538 {

    private int sum;

    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.right);
        sum += root.val;
        root.val = sum;
        inOrder(root.left);
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
