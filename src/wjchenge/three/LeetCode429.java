package wjchenge.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * @author wjchenge
 */
public class LeetCode429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List sub = null;
        while (!q.isEmpty()) {
            sub = new ArrayList();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                sub.add(node.val);
                if (node.children != null) {
                    for(Node children : node.children) {
                        q.add(children);
                    }
                }
            }
            res.add(sub);
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
    }

    public static void main(String[] args) {
        Queue<Node> queue = new LinkedList<>();
        queue.addAll(null);
        System.out.println(queue.poll());
    }

}
