package wjchenge.four;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @author wjchenge
 */
public class LeetCode107 {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        this.dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;
        if (level == res.size()) res.add(0, new ArrayList<>());
        res.get(res.size() - level - 1).add(root.val);
        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
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
