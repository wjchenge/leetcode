package wjchenge.two;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @author wjchenge
 */
public class LeetCode101 {

//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        return this.isSymmetric(root.left, root.right);
//    }
//
//    private boolean isSymmetric(TreeNode left, TreeNode right) {
//        if (left == right) return true;
//        if (left == null || right == null) return false;
//        if (left.val != right.val) return false;
//        return this.isSymmetric(left.left, right.right) && this.isSymmetric(left.right, right.left);
//    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode leftNode = q.poll();
            TreeNode rightNode = q.poll();
            if (leftNode == rightNode) continue;
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;
            q.add(leftNode.left);
            q.add(rightNode.right);
            q.add(leftNode.right);
            q.add(rightNode.left);
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
