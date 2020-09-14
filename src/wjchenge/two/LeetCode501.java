package wjchenge.two;

/**
 * 501. 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * @author wjchenge
 */
public class LeetCode501 {

    private int[] res;
    private int curVal;
    private int curNum;
    private int maxNum;
    private int len;



    public int[] findMode(TreeNode root) {
        this.inOder(root);
        this.res = new int[this.len];
        this.len = 0;
        this.curNum = 0;
        this.inOder(root);
        return res;
    }

    private void inOder(TreeNode root) {
        if (root == null) return;
        inOder(root.left);
        helper(root.val);
        inOder(root.right);
    }

    private void helper(int val) {
        if (this.curVal != val) {
            this.curVal = val;
            this.curNum = 0;
        }
        ++this.curNum;
        if (this.curNum > this.maxNum) {
            this.maxNum = this.curNum;
            this.len = 1;
        } else if (this.curNum == this.maxNum) {
            if (this.res != null) this.res[this.len] = this.curVal;
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
