package wjchenge.three;

/**
 * 83. 删除排序链表中的重复元素
 * @author wjchenge
 */
public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }

        }
        return result;
    }




    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
