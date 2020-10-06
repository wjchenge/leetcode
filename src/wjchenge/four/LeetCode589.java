package wjchenge.four;

import java.util.*;

/**
 * 589. N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @author wjchenge
 */
public class LeetCode589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> q = new Stack<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.pop();
            res.add(node.val);
            if (node.children == null) continue;
            Collections.reverse(node.children);
            q.addAll(node.children);
        }
        return res;
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
