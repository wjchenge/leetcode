package wjchenge.two;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 559. N叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * @author wjchenge
 */
public class LeetCode559 {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        if (root.children == null) return 1;
        for (Node node : root.children) {
            max = Math.max(max, maxDepth(node) + 1);
        }
        return max;
    }


    private class Node {
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
}
