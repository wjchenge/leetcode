package wjchenge.one;

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
        int min;
        if (next == null) {
            min = Integer.MAX_VALUE;
        } else {
            min = next.min;
        }
        min = Math.min(min, x);
        hummy.next = new Node(x, min, next);

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
        private int val;
        private int min;
        private Node next;
        Node(int val, int min,Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();

    }

}
