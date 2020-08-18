package wjchenge.one;

/**
 * 641. 设计循环双端队列
 * https://leetcode-cn.com/problems/design-circular-deque/
 * @author wjchenge
 */
class MyCircularDeque {

    private int capacity;
    private int size;
    private Node head;
    private Node end;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == capacity) return false;
        if (size == 0) {
            head = new Node(value, null, null);
            end = head;
        } else {
            head.pre = new Node(value, null, head);
            head = head.pre;
        }
        ++size;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == capacity) return false;
        if (size == 0) {
            end = new Node(value, null, null);
            head = end;
        } else {
            end.next = new Node(value, end, null);
            end = end.next;
        }
        ++size;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (head == null) return false;
        head = head.next;
        if (--size == 0) {
            end = null;
        } else {
            head.pre = null;
        }
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (end == null) return false;
        end = end.pre;
        if (--size == 0) {
            head = null;
        } else {
            end.next = null;
        }
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head == null ? -1 : head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return end == null ? -1 : end.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    private class Node {
        private int val;
        private Node pre;
        private Node next;

        public Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        /**
         * ["MyCircularDeque","insertFront","getFront","isEmpty","deleteFront","insertLast","getRear","insertLast","insertFront","deleteLast","insertLast","isEmpty"]
         * [[8],[5],[],[],[],[3],[],[7],[7],[],[4],[]]
         */

        MyCircularDeque obj = new MyCircularDeque(8);
        boolean param_1 = obj.insertFront(5);
        int param_5 = obj.getFront();
        boolean param_7 = obj.isEmpty();
        boolean param_3 = obj.deleteFront();
        boolean param_2 = obj.insertLast(3);
        int param_6 = obj.getRear();
        boolean param_9 = obj.insertLast(7);
        boolean param_10 = obj.insertFront(7);
        boolean param_4 = obj.deleteLast();
        boolean param_8 = obj.insertLast(4);
        boolean param_11 = obj.isEmpty();
    }

}
