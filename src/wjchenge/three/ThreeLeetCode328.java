package wjchenge.three;

/**
 * 328. 奇偶链表
 * @author wjchenge
 */
public class ThreeLeetCode328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode tmpEven = evenNode;
        while (tmpEven != null && tmpEven.next != null) {
            oddNode.next = oddNode.next.next;
            oddNode = oddNode.next;
            tmpEven.next = tmpEven.next.next;
            tmpEven = tmpEven.next;
        }
        oddNode.next = evenNode;
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
