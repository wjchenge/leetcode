package wjchenge.one;

/**
 * 24. 两两交换链表中的节点
 * @author wjchenge
 */
public class LeetCode24 {

    /**
     * 递归
     * @param head
     * @return
     */
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode cur = head;
//        ListNode next = head.next;
//        head.next = swapPairs(head.next.next);
//        next.next = head;
//        return next;
//    }

    public ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode pre = listNode;
        while(pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next;
            ListNode next = cur.next;
            pre.next = next;
            cur.next = next.next;
            next.next = cur;
            pre = cur;
        }
        return listNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
