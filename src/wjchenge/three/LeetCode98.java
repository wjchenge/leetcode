package wjchenge.three;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author wjchenge
 */
public class LeetCode98 {


    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return isValidBST(root, min, max);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (!(min < root.val && root.val < max)) return false;
        return isValidBST(root.left, min, root.val) &&
                isValidBST(root.left, root.val, max);
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
