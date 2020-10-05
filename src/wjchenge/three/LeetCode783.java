package wjchenge.three;

/**
 * 783. 二叉搜索树节点最小距离
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * @author wjchenge
 */
public class LeetCode783 {

    private int pre = Integer.MAX_VALUE;

    private int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        this.inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        this.inOrder(root.left);
        min = Math.min(min, Math.abs(root.val - pre));
        pre = root.val;
        this.inOrder(root.right);

    }


    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
