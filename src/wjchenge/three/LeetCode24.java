package wjchenge.three;

/**
 * 24. 两两交换链表中的节点
 * @author wjchenge
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode hummyNode = new ListNode(0);
        hummyNode.next = head;
        ListNode pre = hummyNode;
        while (pre.next != null && pre.next.next != null) {
            ListNode node1= pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            pre.next = node2;
            node2.next = node1;
            node1.next = next;
            pre = node1;
        }
        return hummyNode.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
