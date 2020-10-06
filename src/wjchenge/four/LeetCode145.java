package wjchenge.four;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @author wjchenge
 */
public class LeetCode145 {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(0, node.val);
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }
        return result;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
