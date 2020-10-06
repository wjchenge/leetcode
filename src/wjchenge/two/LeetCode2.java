package wjchenge.two;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author wjchenge
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 == null) {
                if (carry == 0) {
                    tmp.next = l2;
                    break;
                } else {
                    sum = l2.val + carry;
                }
                l2 = l2.next;
            } else if (l2 == null) {
                if (carry == 0) {
                    tmp.next = l1;
                    break;
                } else {
                    sum = l1.val + carry;
                }
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = sum / 10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
        }
        if (carry == 1) {
            tmp.next = new ListNode(1);
        }
        return res;
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
