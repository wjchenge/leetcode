package wjchenge.three;

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
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                fastNode = head;
                while (fastNode != slowNode) {
                    fastNode = fastNode.next;
                    slowNode = slowNode.next;
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
