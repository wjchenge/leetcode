package wjchenge.four;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @author wjchenge
 */
public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == right) return true;
        if (left == null || right == null) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left) && right.val == left.val;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if (l == r) continue;
            if (l == null || r == null || l.val != r.val) return false;
            q.add(l.left);
            q.add(r.right);
            q.add(l.right);
            q.add(r.left);
        }
        return true;
    }


    private class TreeNode {
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

}
