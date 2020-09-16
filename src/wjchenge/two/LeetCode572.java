package wjchenge.two;

/**
 * 572. 另一个树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @author wjchenge
 */
public class LeetCode572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return this.isSubtree(s.left, t) || this.isSubtree(s.right, t) || isSame(s, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == t) return true;
        if (s == null || t == null) return false;
        return isSame(s.left, t.left) && isSame(s.right, s.right) && s.val == t.val;
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
