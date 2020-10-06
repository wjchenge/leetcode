package wjchenge.four;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author wjchenge
 */
public class LeetCode104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
