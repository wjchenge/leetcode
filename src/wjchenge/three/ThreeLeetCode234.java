package wjchenge.three;

/**
 * 234. 回文链表
 * @author wjchenge
 */
public class ThreeLeetCode234 {

    public static boolean isPalindrome(ListNode head) {
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
        if (fastNode != null) cur = cur.next;
        while (cur != null) {
            if (pre.val != cur.val) return false;
            pre = pre.next;
            cur = cur.next;
        }
        return true;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);
        isPalindrome(listNode);
    }

}
