package wjchenge.three;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @author wjchenge
 */
public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
