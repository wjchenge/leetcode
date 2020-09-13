package wjchenge.one;

/**
 * 501. 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * @author wjchenge
 */
public class LeetCode501 {

    private int len;
    private int[] res;
    private int curVal;
    private int num;
    private int max;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        res = new int[len];
        len = 0;
        num = 0;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        helper(root.val);
        inOrder(root.right);
    }

    private void helper(int val) {
        if (this.curVal != val) {
            this.curVal = val;
            this.num = 0;
        }
        ++this.num;
        if (this.num > this.max) {
            this.max = this.num;
            this.len = 1;
        } else if (this.num == this.max) {
            if (this.res != null) this.res[len] = this.curVal;
            ++this.len;
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
