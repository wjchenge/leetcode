package wjchenge.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * @author wjchenge
 */
public class LeetCode515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        this.dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;
        if (level == res.size()) res.add(Integer.MIN_VALUE);
        res.set(level, Math.max(root.val, res.get(level)));
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
