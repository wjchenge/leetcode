package wjchenge.four;

/**
 * 142. 环形链表 II
 * @author wjchenge
 */
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slowNode = head.next;
        ListNode fastNode = head.next.next;
        while (fastNode != null && fastNode.next != null) {
            if (fastNode == slowNode) {
                fastNode = head;
                while (fastNode != slowNode) {
                    fastNode = fastNode.next;
                    slowNode = slowNode.next;
                }
                return fastNode;
            } else {
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
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
