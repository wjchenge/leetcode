package wjchenge.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 206. 反转链表
 * @author wjchenge
 */
public class LeetCode206 {

    /**
     * 迭代
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode listNode = reverseList(next);
        next.next = head;
        head.next = null;
        return listNode;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
