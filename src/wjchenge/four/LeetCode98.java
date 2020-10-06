package wjchenge.four;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author wjchenge
 */
public class LeetCode98 {


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val < min || root.val > max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);

    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
