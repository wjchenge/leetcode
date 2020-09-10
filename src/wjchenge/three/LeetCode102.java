package wjchenge.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @author wjchenge
 */
public class LeetCode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        this.dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;
        if (level == res.size()) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        this.dfs(root.left, level + 1, res);
        this.dfs(root.right, level + 1, res);
    }


    private class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
    }


}
