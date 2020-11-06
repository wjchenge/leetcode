package restart.wjchenge.one;

import java.util.*;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Leetcode203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode hummyNode = new ListNode(0);
        hummyNode.next = head;
        ListNode pre = hummyNode;
        ListNode cur = head;
        while (cur != null) {
             if (cur.val == val) {
                 pre.next = cur.next;
             }  else {
                 pre = cur;
             }
             cur = cur.next;

        }
        return hummyNode.next;
    }


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

}
