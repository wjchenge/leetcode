package wjchenge.three;

import com.sun.org.apache.xerces.internal.impl.xs.util.XInt;

import java.util.concurrent.LinkedTransferQueue;

/**
 * 155. 最小栈
 * @author wjchenge
 */
 class MinStack {

     Node hummyNode;

    /** initialize your data structure here. */
    public MinStack() {
        hummyNode = new Node(0, 0, null);
    }

    public void push(int x) {
        if (hummyNode.next == null) {
            hummyNode.next = new Node(x, x, null);
        } else {
            hummyNode.next = new Node(x, Math.min(x, hummyNode.next.min), hummyNode.next);
        }
    }

    public void pop() {
        hummyNode.next = hummyNode.next.next;

    }

    public int top() {
        return hummyNode.next.val;
    }

    public int getMin() {
        return hummyNode.next.min;
    }

    private class Node {
        private int val;
        private int min;
        private Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

}
