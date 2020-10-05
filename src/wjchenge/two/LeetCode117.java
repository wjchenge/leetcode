package wjchenge.two;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  117. 填充每个节点的下一个右侧节点指针 II
 *  https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @author wjchenge
 */
public class LeetCode117 {

    public Node connect(Node root) {
        Node resNode = root;
        while (root != null) {
            Node node = new Node(0);
            Node tmp = node;
            while (root != null) {
                if (root.left != null) {
                    tmp.next = root.left;
                    tmp = tmp.next;
                }
                if (root.right != null) {
                    tmp.next = root.right;
                    tmp = tmp.next;
                }
                root = root.next;
            }
            root = node.next;
        }
        return resNode;
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
