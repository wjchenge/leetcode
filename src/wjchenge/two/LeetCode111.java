package wjchenge.two;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @author wjchenge
 */
public class LeetCode111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int l_min = minDepth(root.left);
        int r_min = minDepth(root.right);
        return ((l_min == 0 || r_min == 0) ?
                l_min + r_min:
                Math.min(l_min, r_min)) + 1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
