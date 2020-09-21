package wjchenge.three;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * @author wjchenge
 */
public class LeetCode538 {

    private int sum;

    public TreeNode convertBST(TreeNode root) {
        this.inOrder(root);
        return root;

    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        this.inOrder(root.right);
        root.val += sum;
        sum = root.val;
        this.inOrder(root.left);

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
