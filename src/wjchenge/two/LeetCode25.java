package wjchenge.two;

/**
 * 25. K 个一组翻转链表
 * @author wjchenge
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        ListNode hummyNode = new ListNode(0);
        hummyNode.next = head;
        ListNode pre = hummyNode;
        ListNode end = hummyNode;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode next = end.next;
            end.next = null;
            pre.next = this.reverseList(head);
            head.next = next;
            pre = head;
            end = head;
            head = next;
        }
        return hummyNode.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
