package wjchenge.two;

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
            Node node = new Node(value,null, head);
            head.pre = node;
            head = node;
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
            Node node = new Node(value,end, null);
            end.next = node;
            end = node;
        }
        ++size;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) return false;
        head = head.next;
        if (--size > 0) {
            head.pre = null;
        }
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) return false;
        end = end.pre;
        if (--size > 0) {
            end.next = null;
        }
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return size == 0 ? -1 : head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return size == 0 ? -1 : end.val;
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


}
