package wjchenge.four;

/**
 * 24. 两两交换链表中的节点
 * @author wjchenge
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode next = l2.next;
        l2.next = l1;
        l1.next = swapPairs(next);
        return l2;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
