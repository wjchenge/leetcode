package wjchenge.one;

/**
 * 两数相加
 * @author wjchenge
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;


        ListNode result = new ListNode(0);
        //临时操作节点
        ListNode tmp = result;
        //保存进位信息
        int k = 0;
        while (l1 != null || l2 != null) {
            int i = 0;
            if (l1 != null) {
                i = l1.val;
                l1 = l1.next;
            }

            int j = 0;
            if (l2 != null) {
                j = l2.val;
                l2 = l2.next;
            }

            int sum = i + j + k;
            k = sum / 10;
            sum = sum % 10;
            tmp.next = new ListNode(sum);
            tmp = tmp.next;
        }

        if (k == 1) {
            tmp.next = new ListNode(k);
        }

        return result.next;

    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
