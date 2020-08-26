package wjchenge.one;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @author wjchenge
 */
public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;

    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
