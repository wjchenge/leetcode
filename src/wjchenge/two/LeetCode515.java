package wjchenge.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * @author wjchenge
 */
public class LeetCode515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        this.largestValues(root, 0, res);
        return res;
    }

    private void largestValues(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;
        if (level == res.size()) res.add(Integer.MIN_VALUE);
        res.set(level, Math.max(res.get(level), root.val));
        this.largestValues(root.left, level + 1, res);
        this.largestValues(root.right, level + 1, res);
    }


    private class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
    }


}
