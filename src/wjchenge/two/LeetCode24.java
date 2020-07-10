package wjchenge.two;

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
//        ListNode next = head.next;
//        next.next = head;
//        head.next = swapPairs(next.next);
//        return next;
//    }


    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode p = listNode;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            node1.next = node2.next;
            node2.next = node1;
            p.next = node2;
            p = node1;
        }
        return listNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
