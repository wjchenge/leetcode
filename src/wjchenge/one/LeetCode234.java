package wjchenge.one;

import java.util.Stack;

/**
 * 234. 回文链表
 * @author wjchenge
 */
public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next ==null) return true;
        ListNode tmpNode = new ListNode(0);
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode pre = null;
        ListNode cur = slowNode;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slowNode.next = null;
        return isEqual(head, pre);
    }

    private boolean isEqual(ListNode head, ListNode pre) {
        while (head != null && pre != null) {
            if (head.val != pre.val) return false;
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
