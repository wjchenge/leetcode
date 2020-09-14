package wjchenge.two;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * @author wjchenge
 */
public class LeetCode538 {

    private int sum;

    public TreeNode convertBST(TreeNode root) {
        inOrderReverse(root);
        return root;
    }

    private void inOrderReverse(TreeNode root) {
        if (root == null) return;
        this.inOrderReverse(root.right);
        sum += root.val;
        root.val = sum;
        this.inOrderReverse(root.left);

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
