package wjchenge.three;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
            int level = 0;
            int size = q.size();
            while (size-- > 0) {
                int oneParent = 0;
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    if (node.left.val == x || node.left.val == y) {
                        ++level;
                        ++oneParent;
                    }
                }
                if (node.right != null) {
                    q.add(node.right);
                    if (node.right.val == x || node.right.val == y) {
                        ++level;
                        ++oneParent;
                    }
                }
                if (oneParent == 2) return false;
            }
            if (level == 2) return true;
        }
        return false;
    }

    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
