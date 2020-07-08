package wjchenge.two;

/**
 * 206. 反转链表
 * @author wjchenge
 */
public class LeetCode206 {

    /**
     * 迭代
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next ==null) return head;
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next ==null) return head;
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
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
