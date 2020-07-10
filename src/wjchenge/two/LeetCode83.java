package wjchenge.two;

/**
 * 83. 删除排序链表中的重复元素
 * @author wjchenge
 */
public class LeetCode83 {

    /**
     * 迭代
     * @param head
     * @return
     */
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode cur = head;
//        while (cur != null && cur.next != null) {
//            if (cur.val == cur.next.val) {
//                cur.next = cur.next.next;
//            } else {
//                cur = cur.next;
//            }
//
//        }
//        return head;
//    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }




    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
