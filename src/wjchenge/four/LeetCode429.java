package wjchenge.four;

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
        while (!q.isEmpty()) {
            int size = q.size();
            res.add(new ArrayList<>());
            while (size-- > 0) {
                Node node = q.poll();
                res.get(res.size() - 1).add(node.val);
                if (node.children == null) continue;
                q.addAll(node.children);
            }
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
