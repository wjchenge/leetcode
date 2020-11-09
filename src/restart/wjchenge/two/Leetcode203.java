package restart.wjchenge.two;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Leetcode203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode hummyNode = new ListNode(0);
        hummyNode.next = head;
        ListNode pre = hummyNode;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = pre.next;
        }
        return hummyNode.next;
    }


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

}
