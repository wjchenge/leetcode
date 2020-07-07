package wjchenge.one;

/**
 * 160. 相交链表
 * @author wjchenge
 */
public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode listNodeA = headA;
        ListNode listNodeB = headB;
        while (listNodeA != listNodeB) {
            listNodeA = (listNodeA == null) ? listNodeB : listNodeA.next;
            listNodeB = (listNodeB == null) ? listNodeA : listNodeB.next;
        }
        return listNodeA;
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
