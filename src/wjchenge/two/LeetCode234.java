package wjchenge.two;

/**
 * 234. 回文链表
 * @author wjchenge
 */
public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        //空链表或一个节点的列表为回文链表
        if (head == null || head.next == null) return true;

        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        //反转后半部分
        ListNode pre = null;
        ListNode reverse = fastNode == null ? slowNode : slowNode.next;
        while (reverse != null) {
            ListNode next = reverse.next;
            reverse.next = pre;
            pre = reverse;
            reverse = next;
        }
        slowNode.next = null;
        return isEquals(pre, head);

    }

    private boolean isEquals(ListNode node1, ListNode node2) {
        while (node1 != null && node2 != null) {
            if (node1.val != node2.val) return false;
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1 == node2;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        LeetCode234 leetCode234 = new LeetCode234();
        ListNode l = leetCode234.new ListNode(1);
        l.next = leetCode234.new ListNode(1);
        leetCode234.isPalindrome(l);
    }

}
