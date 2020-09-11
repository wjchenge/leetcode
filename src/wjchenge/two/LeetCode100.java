package wjchenge.two;


/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 * @author wjchenge
 */
public class LeetCode100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true;
        if (p == null || q == null) return false;
        if (q.val != p.val) return false;
        return this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
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
