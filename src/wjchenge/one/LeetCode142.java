package wjchenge.one;

/**
 * 142. 环形链表 II
 * @author wjchenge
 */
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                fastNode = head;
                while (slowNode != fastNode) {
                    slowNode = slowNode.next;
                    fastNode = fastNode.next;
                }
                return fastNode;
            }
        }

        return null;

    }


     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}
