package wjchenge.four;

/**
 * 328. 奇偶链表
 * @author wjchenge
 */
public class LeetCode328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode tmpEvenNode = evenNode;
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = evenNode.next;
            evenNode.next = oddNode.next;
            evenNode = oddNode.next;
        }
        oddNode.next = tmpEvenNode;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
