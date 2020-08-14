package wjchenge.two;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;

/**
 * 155. 最小栈
 * @author wjchenge
 */
 class MinStack {

     private Node hummy;

    /** initialize your data structure here. */
    public MinStack() {
        hummy = new Node(0, 0, null);
    }

    public void push(int x) {
       Node next = hummy.next;
       if (next == null) {
           hummy.next = new Node(x, x, null);
       } else {
           hummy.next = new Node(x, Math.min(x, next.min), next);
       }
    }

    public void pop() {
        hummy.next = hummy.next.next;
    }

    public int top() {
        return hummy.next.val;
    }

    public int getMin() {
        return hummy.next.min;
    }

    class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

}
