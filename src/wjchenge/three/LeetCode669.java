package wjchenge.three;

/**
 * 669. 修剪二叉搜索树
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 * @author wjchenge
 */
public class LeetCode669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (low > root.val) return trimBST(root.right, low, high);
        if (high < root.val) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
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
