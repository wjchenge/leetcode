package wjchenge.two;

/**
 * 160. 相交链表
 * @author wjchenge
 */
public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode NodeA = headA;
        ListNode NodeB = headB;
        while (NodeA != NodeB) {
            NodeA = (NodeA == null) ? headB : NodeA.next;
            NodeB = (NodeB == null) ? headA : NodeB.next;
        }
        return NodeA;
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
