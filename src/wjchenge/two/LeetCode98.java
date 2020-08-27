package wjchenge.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author wjchenge
 */
public class LeetCode98 {

//    private long pre = Long.MIN_VALUE;
//
//    public boolean isValidBST(TreeNode root) {
//        return this.inorder(root);
//    }
//
//    private boolean inorder(TreeNode root) {
//        if (root == null) return true;
//        if (!inorder(root.left)) return false;
//        if (pre >= root.val) return false;
//        pre = root.val;
//        return inorder(root.right);
//    }

    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return this.isValidBST(root, min, max);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
