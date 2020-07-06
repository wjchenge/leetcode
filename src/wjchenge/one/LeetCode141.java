package wjchenge.one;

import java.util.concurrent.TimeUnit;

/**
 * 141. 环形链表
 * @author wjchenge
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (slowNode != null && fastNode != null && fastNode.next != null) {
            if (slowNode == fastNode) return true;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return false;
    }


     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}
