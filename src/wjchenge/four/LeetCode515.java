package wjchenge.four;

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
        this.dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        if (res.size() == level) res.add(Integer.MIN_VALUE);
        res.set(level, Math.max(res.get(level), root.val));
        this.dfs(root.left, res, level + 1);
        this.dfs(root.right, res, level + 1);
    }


    private class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
    }


}
