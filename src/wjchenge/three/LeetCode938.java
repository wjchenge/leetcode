package wjchenge.three;

/**
 * 938. 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * @author wjchenge
 */
public class LeetCode938 {

    private int sum;

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSumBST(root.right, L, R);
        if (root.val > R) return rangeSumBST(root.left, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);

    }



    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
