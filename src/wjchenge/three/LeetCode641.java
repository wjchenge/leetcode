package wjchenge.three;

/**
 * 641. 设计循环双端队列
 * https://leetcode-cn.com/problems/design-circular-deque/
 * @author wjchenge
 */
class MyCircularDeque {

    private int[] data;

    private int front, last;

    private int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k + 1;
        data = new int[capacity];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        data[front] = value;
        front = (front - 1 + capacity) % capacity;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        last = (last + 1) % capacity;
        data[last] = value;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        last = (last - 1 + capacity) % capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return data[(front + 1) % capacity];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return data[last];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == last;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (last + 1) % capacity == front;
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(5);
        deque.insertFront(7);
        deque.insertLast(0);
        System.out.println(deque.getFront());
        deque.insertLast(3);
        System.out.println(deque.getFront());
        deque.insertFront(9);
        System.out.println(deque.getRear());
        System.out.println(deque.getFront());
        System.out.println(deque.getFront());
        System.out.println(deque.deleteLast());
        System.out.println(deque.getRear());

    }
}
