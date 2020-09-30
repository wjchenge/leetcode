package wjchenge.two;


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
        dfs(root, sum, res, new ArrayList<>());
        return res;


    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> li) {
        if (root == null) return;
        li.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(li));
            li.remove(li.size() - 1);
            return;
        }
        dfs(root.left, sum - root.val, res, li);
        dfs(root.right, sum - root.val, res, li);
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
