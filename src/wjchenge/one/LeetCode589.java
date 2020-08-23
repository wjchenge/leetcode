package wjchenge.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @author wjchenge
 */
public class LeetCode589 {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        this.doPreorder(root, result);
        return result;
    }

    private void doPreorder(Node root, List<Integer> result) {
        if (root == null) return;
        List<Node> children = root.children;
        result.add(root.val);
        if (children != null) {
            for (Node node : children) {
                this.doPreorder(node, result);
            }
        }

    }

    public List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Commend> stack = new Stack<>();
        stack.push(new Commend(false, root));
        while (!stack.isEmpty()) {
            Commend commend = stack.pop();
            if (commend.print) {
                result.add(commend.node.val);
            } else {
                List<Node> children = commend.node.children;
                if (children != null) {
                    for (int i = children.size() - 1; i >= 0 ; i--) {
                        stack.push(new Commend(false, children.get(i)));
                    }
                }
                stack.push(new Commend(true, commend.node));
            }
        }
        return result;
    }

    private class Commend {
        private boolean print;
        private Node node;

        public Commend(boolean print, Node node) {
            this.print = print;
            this.node = node;
        }
    }

    class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

}
