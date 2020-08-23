package wjchenge.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @author wjchenge
 */
public class LeetCode145 {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        this.postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        this.postorderTraversal(root.left, result);
        this.postorderTraversal(root.right, result);
        result.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command(false, root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.print) {
                result.add(command.node.val);
            } else {
                stack.push(new Command(true, command.node));
                if (command.node.right != null) {
                    stack.push(new Command(false, command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command(false, command.node.left));
                }
            }
        }
        return result;
    }

    private class Command {
        private boolean print;
        private TreeNode node;

        public Command(boolean print, TreeNode node) {
            this.print = print;
            this.node = node;
        }
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
