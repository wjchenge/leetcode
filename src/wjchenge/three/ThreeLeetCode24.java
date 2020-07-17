package wjchenge.three;

/**
 * 24. 两两交换链表中的节点
 * @author wjchenge
 */
public class ThreeLeetCode24 {

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = head.next.next;
        next.next = head;
        head.next = swapPairs(head.next);
        return next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
