package wjchenge.one;

/**
 * 19. 删除链表的倒数第N个节点
 * @author wjchenge
 */
public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        ListNode slowNode = head;
        ListNode fastNode = head;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        if (fastNode == null) return head.next;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
