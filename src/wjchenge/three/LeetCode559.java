package wjchenge.three;

import java.util.List;

/**
 * 559. N叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * @author wjchenge
 */
public class LeetCode559 {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.isEmpty()) return 1;
        int max = 0;
        for (Node node : root.children) {
            max = Math.max(max, maxDepth(node));
        }
        return max + 1;
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
