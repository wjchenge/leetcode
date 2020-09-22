package wjchenge.one;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 993. 二叉树的堂兄弟节点
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * @author wjchenge
 */
public class LeetCode993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int res = 0;
            while (size-- > 0) {
                int cnt = 0;
                TreeNode node = q.poll();
                if (x == node.val || y == node.val) ++res;
                if (node.left != null) {
                    q.add(node.left);
                    if (x == node.left.val || y == node.left.val) ++cnt;
                }
                if (node.right != null) {
                    q.add(node.right);
                    if (x == node.right.val || y == node.right.val) ++cnt;
                }
                if (cnt == 2) return false;
            }
            if (res == 2) {
                return true;
            }
        }
        return false;
    }


    private boolean dfs(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        return dfs(root.left, val) && dfs(root.right, val);
    }


    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
