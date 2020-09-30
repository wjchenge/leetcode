package wjchenge.one;

import java.util.*;

/**
 *  117. 填充每个节点的下一个右侧节点指针 II
 *  https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @author wjchenge
 */
public class LeetCode117 {

    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node next = null;
            while (size-- > 0) {
                Node node = q.poll();
                node.next = next;
                next = node;
                if (node.right != null) q.add(node.right);
                if (node.left != null) q.add(node.left);
            }
            next = null;
        }
        return root;
    }


    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
