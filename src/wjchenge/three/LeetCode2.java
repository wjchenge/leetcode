package wjchenge.three;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author wjchenge
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 == null && l2 == null) {
                sum = carry;
                carry = 0;
            } else if (l1 == null) {
                sum = l2.val + carry;
                carry = sum / 10;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carry;
                carry = sum / 10;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                carry = sum / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
        }
        return res.next;
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
