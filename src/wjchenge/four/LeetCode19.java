package wjchenge.four;

/**
 * 19. 删除链表的倒数第N个节点
 * @author wjchenge
 */
public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hummy = new ListNode(0);
        hummy.next = head;
        ListNode slowNode = hummy;
        ListNode fastNode = hummy;
        while (n-- > 0) {
            fastNode = fastNode.next;
        }
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return hummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
