package wjchenge.two;

import java.util.LinkedList;
import java.util.Queue;

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
            int num = 0;//同一层找到几个目标节点
            int size = q.size();
            while (size-- > 0) {
                int oneParent = 0;
                TreeNode node = q.poll();
                if (node.val == x || node.val == y) ++num;
                if (node.left != null) {
                    q.add(node.left);
                    if (node.left.val == x || node.left.val == y) ++oneParent;
                }
                if (node.right != null) {
                    q.add(node.right);
                    if (node.right.val == x || node.right.val == y) ++oneParent;
                }
                if (oneParent == 2) return false;
            }
            if (num == 2) return true;
            if (num == 1) return false;
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
