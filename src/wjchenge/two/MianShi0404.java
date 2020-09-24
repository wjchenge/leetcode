package wjchenge.two;

/**
 * 面试题 04.04. 检查平衡性
 * https://leetcode-cn.com/problems/check-balance-lcci/
 * @author wjchenge
 */
public class MianShi0404 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = getHight(root.left);
        int r = getHight(root.right);
        return Math.abs(l - r) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHight(root.left), getHight(root.right)) + 1;
    }


    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
