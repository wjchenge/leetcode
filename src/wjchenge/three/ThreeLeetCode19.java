package wjchenge.three;

/**
 * 19. 删除链表的倒数第N个节点
 * @author wjchenge
 */
public class ThreeLeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode slow = result;
        ListNode fast = result;
        while (n-- >= 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
