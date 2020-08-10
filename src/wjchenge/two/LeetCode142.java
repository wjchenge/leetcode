package wjchenge.two;

/**
 * 142. 环形链表 II
 * @author wjchenge
 */
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
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
