package wjchenge.three;

/**
 * 687. 最长同值路径
 * https://leetcode-cn.com/problems/longest-univalue-path/
 * @author wjchenge
 */
public class LeetCode687 {

    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root, root.val);
        return max;
    }

    private int helper(TreeNode root, int val) {
        if (root == null) return 0;
        int l = helper(root.left, root.val);
        int r = helper(root.right, root.val);
        max = Math.max(max, l + r);
        if (val == root.val) return Math.max(l, r) + 1;
        return 0;
    }

    private static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(8);
        node.left.left = new TreeNode(8);
        node.right = new TreeNode(8);
        int i = new LeetCode687().longestUnivaluePath(node);
        System.out.println(i);
    }
}
