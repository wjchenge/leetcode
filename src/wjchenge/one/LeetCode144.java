package wjchenge.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @author wjchenge
 */
public class LeetCode144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        this.doPreorderTraversal(root, result);
        return result;
    }

    private void doPreorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        this.doPreorderTraversal(root.left, result);
        this.doPreorderTraversal(root.right, result);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
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
                if (command.node.left != null) {
                    stack.push(new Command(false, command.node.left));
                }
                stack.push(new Command(true, command.node));
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
