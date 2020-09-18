package wjchenge.four;

/**
 * 25. K 个一组翻转链表
 * @author wjchenge
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode hummyHead = new ListNode(0);
        hummyHead.next = head;
        ListNode pre = hummyHead;
        ListNode end = hummyHead;
        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode nextPre = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseList(pre.next);
            pre = nextPre;
            pre.next = next;
            end = pre;
        }
        return hummyHead.next;

    }

    private ListNode reverseList(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
