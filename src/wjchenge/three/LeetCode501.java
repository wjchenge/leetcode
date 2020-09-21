package wjchenge.three;

/**
 * 501. 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * @author wjchenge
 */
public class LeetCode501 {

    private int[] res;
    private int len;
    private int curVal;
    private int curNum;
    private int maxNum;


    public int[] findMode(TreeNode root) {
        this.inOrder(root);
        res = new int[len];
        curVal = 0;
        curNum = 0;
        len = 0;
        this.inOrder(root);
        return res;

    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        this.helper(root.val);
        inOrder(root.right);
    }

    private void helper(int val) {
        if (val != curVal) {
            curVal = val;
            curNum = 0;
        }
        ++curNum;
        if (curNum > maxNum) {
            maxNum = curNum;
            len = 1;
        } else if (curNum == maxNum) {
            if (res != null) res[len] = curVal;
            ++len;
        }
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
