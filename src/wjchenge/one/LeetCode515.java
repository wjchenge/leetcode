package wjchenge.one;

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
        if (root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int max = Integer.MIN_VALUE;
                int size = q.size();
                while (size-- > 0) {
                    TreeNode node = q.poll();
                    max = Math.max(max, node.val);
                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }
                res.add(max);
            }
        }
        return res;
    }


    private class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
    }


}
