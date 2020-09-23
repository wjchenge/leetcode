package wjchenge.two;

/**
 * 965. 单值二叉树
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 * @author wjchenge
 */
public class LeetCode965 {

    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);

    }

    private boolean dfs(TreeNode root, int val) {
        if (root == null) return true;
        return dfs(root.left, val) && dfs(root.right, val) && root.val == val;
    }


    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
