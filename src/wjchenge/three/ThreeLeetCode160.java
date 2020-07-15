package wjchenge.three;

/**
 * 160. 相交链表
 * @author wjchenge
 */
public class ThreeLeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpHeadA = headA;
        ListNode tmpHeadB = headB;
        while (headA !=  headB) {
            headA = (headA == null ? tmpHeadB : headA.next);
            headB = (headB == null ? tmpHeadA : headB.next);
        }
        return headA;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
