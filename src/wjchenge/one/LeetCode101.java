package wjchenge.one;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @author wjchenge
 */
public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == root.right) return true;
        if (root.left == null || root.right == null) return false;
        Deque<Order> q = new ArrayDeque<>();
        q.push(new Order(true, root.left));
        q.push(new Order(false, root.right));
        while (!q.isEmpty()) {
            if (q.size() % 2 == 1) return false;
            Order left = q.poll();
            Order right = q.poll();
            if (left.left == right.left) return false;
            TreeNode leftNode = left.treeNode;
            TreeNode rightNode = right.treeNode;
            if (leftNode.val != rightNode.val) return false;
            if (leftNode.left != null) q.push(new Order(true, leftNode.left));
            if (rightNode.right != null) q.push(new Order(false, rightNode.right));
            if (leftNode.right != null) q.push(new Order(false, leftNode.right));
            if (rightNode.left != null) q.push(new Order(true, rightNode.left));
        }
        return true;

    }

    private class Order {
        private boolean left;
        private TreeNode treeNode;

        public Order(boolean left, TreeNode treeNode) {
            this.left = left;
            this.treeNode = treeNode;
        }
    }

    public boolean isSymmetric3(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == right) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;

    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return this.isSymmetric2(root.left, root.right);

    }

    private boolean isSymmetric2(TreeNode left, TreeNode right) {
        if (left == right) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric2(left.left, right.right) && isSymmetric2(left.right, right.left);
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
