package wjchenge.two;

/**
 * 1022. 从根到叶的二进制数之和
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 * @author wjchenge
 */
public class LeetCode1022 {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 2 + root.val;
        return (root.left == root.right ? val : dfs(root.left, val) + dfs(root.right, val));

    }


    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
