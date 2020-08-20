package wjchenge.four;

import java.util.Stack;

/**
 * 445. 两数相加 II
 * @author wjchenge
 */
public class LeetCode445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode hummyNode = new ListNode(0);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry == 1) {
            int i = stack1.isEmpty() ? 0 : stack1.pop();
            int j = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = i + j + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = hummyNode.next;
            hummyNode.next = node;
        }
        return hummyNode.next;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
