package wjchenge.four;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;

/**
 * 155. 最小栈
 * @author wjchenge
 */
 class MinStack {

     private Node cur;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (cur == null) {
            cur = new Node(x, x, null);
        } else {
            Node node = new Node(x, Math.min(cur.minVal, x), cur);
            cur = node;
        }
    }

    public void pop() {
        cur = cur.pre;
    }

    public int top() {
        return cur.val;
    }

    public int getMin() {
        return cur.minVal;
    }

    private class Node {
        private int val;
        private int minVal;
        private Node pre;

        public Node(int val, int minVal, Node pre) {
            this.val = val;
            this.minVal = minVal;
            this.pre = pre;
        }
    }
}
