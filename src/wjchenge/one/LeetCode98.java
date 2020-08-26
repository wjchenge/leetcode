package wjchenge.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author wjchenge
 */
public class LeetCode98 {

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.inorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST2(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (minValue >= root.val || root.val >= maxValue) return false;
        return isValidBST2(root.left, minValue, root.val) &&
                isValidBST2(root.right, root.val, maxValue);
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println(2147483647);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE < Long.MAX_VALUE);
    }

}
