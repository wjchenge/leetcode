package wjchenge.two;

/**
 * 938. 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * @author wjchenge
 */
public class LeetCode938 {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (L > root.val) return rangeSumBST(root.right, L, R);
        if (R < root.val) return rangeSumBST(root.left, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }



    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
