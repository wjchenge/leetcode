package wjchenge.three;

/**
 * 83. 删除排序链表中的重复元素
 * @author wjchenge
 */
public class ThreeLeetCode83 {

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        head.next = (head.val == head.next.val ? head.next.next : head.next);
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
