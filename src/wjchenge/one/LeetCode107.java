package wjchenge.one;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层次遍历 II
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @author wjchenge
 */
public class LeetCode107 {

//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> res = new LinkedList<>();
//        if (root == null) return res;
//        Queue<TreeNode> q = new LinkedList();
//        q.add(root);
//        while (!q.isEmpty()) {
//            int size = q.size();
//            List<Integer> list = new ArrayList<>(size);
//            while (size-- > 0) {
//                TreeNode node = q.poll();
//                list.add(node.val);
//                if (node.left != null) q.add(node.left);
//                if (node.right != null) q.add(node.right);
//            }
//            res.add(0, list);
//        }
//        return res;
//    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        this.dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;
        if (level == res.size()) res.add(0, new ArrayList<>());
        res.get(res.size() - level - 1).add(root.val);
        this.dfs(root.left, level + 1, res);
        this.dfs(root.right, level + 1, res);
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
