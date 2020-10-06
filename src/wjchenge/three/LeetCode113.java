package wjchenge.three;


import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 * @author wjchenge
 */
public class LeetCode113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        this.dfs(root, sum, res, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> li) {
        if (root == null) return;
        if (root.val == sum && root.left == null && root.right == null) {
            li.add(root.val);
            res.add(new ArrayList<>(li));
            li.remove(li.size() - 1);
            return;
        }
        li.add(root.val);
        this.dfs(root.left, sum - root.val, res, li);
        this.dfs(root.right, sum - root.val, res, li);
        li.remove(li.size() - 1);
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
