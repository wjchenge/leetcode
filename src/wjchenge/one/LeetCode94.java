package wjchenge.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author wjchenge
 */
public class LeetCode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        this.doInorderTraversal(root, result);
        return result;
    }

    private void doInorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        doInorderTraversal(root.left, result);
        result.add(root.val);
        doInorderTraversal(root.right, result);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command(false, root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.print) {
                result.add(command.node.val);
            } else {
                if (command.node.right != null) {
                    stack.push(new Command(false, command.node.right));
                }
                stack.push(new Command(true, command.node));
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
