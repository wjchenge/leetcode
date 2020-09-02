package wjchenge.one;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @author wjchenge
 */
public class LeetCode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(list);
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
