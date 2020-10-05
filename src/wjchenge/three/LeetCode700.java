package wjchenge.three;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * @author wjchenge
 */
public class LeetCode700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val < val) return searchBST(root.right, val);
        if (root.val > val) return searchBST(root.left, val);
        return root;
    }



     private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
