package wjchenge.three;

/**
 * 897. 递增顺序查找树
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * @author wjchenge
 */
public class LeetCode897 {

    private TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        this.inOrder(root);
        return cur;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        this.inOrder(root.right);
        root.right = cur;
        cur = root;
        this.inOrder(root.left);
        root.left = null;
    }


    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
