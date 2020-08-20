package wjchenge.four;

/**
 * 234. 回文链表
 * @author wjchenge
 */
public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode pre = null;
        ListNode cur = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (fastNode != null) {
            cur = cur.next;
        }
        while (cur != null && pre != null) {
            if (cur.val != pre.val) return false;
            cur = cur.next;
            pre = pre.next;
        }
        return cur == pre;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
