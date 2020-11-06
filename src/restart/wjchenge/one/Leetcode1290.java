package restart.wjchenge.one;

/**
 * 1290. 二进制链表转整数
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class Leetcode1290 {

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res <<= 1;
            res += head.val;
            head = head.next;
        }
        return res;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
