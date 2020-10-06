package wjchenge.four;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @author wjchenge
 */
public class LeetCode111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (l == 0) return r + 1;
        if (r == 0) return l + 1;
        return Math.min(l, r) + 1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
