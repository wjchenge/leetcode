package wjchenge.one;

/**
 * 965. 单值二叉树
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 * @author wjchenge
 */
public class LeetCode965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return false;
        return this.dfs(root.left, root.val) && this.dfs(root.right, root.val);


    }

    private boolean dfs(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        return dfs(root.left, val) && dfs(root.right, val);
    }


    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
