package restart.wjchenge.one;

/**
 * 61. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class Leetcode61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode node1 = dummyNode;
        ListNode node2 = dummyNode;
        int len = 0;
        while (node1.next != null) {
            ++len;
            node1 = node1.next;
        }

        for (int i = len - k % len; i > 0; --i) {
            node2 = node2.next;
        }

        node1.next = dummyNode.next;
        dummyNode.next = node2.next;
        node2.next = null;
        return dummyNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
