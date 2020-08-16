package wjchenge.four;

/**
 * 21. 合并两个有序链表
 * @author wjchenge
 */
public class LeetCode21 {

    /**
     * 迭代
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode hummy = new ListNode(0);
        ListNode result = hummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                hummy.next = l2;
                break;
            } else if (l2 == null) {
                hummy.next = l1;
                break;
            } else if (l1.val < l2.val) {
                hummy.next = l1;
                l1 = l1.next;
                hummy = hummy.next;
            } else {
                hummy.next = l2;
                l2 = l2.next;
                hummy = hummy.next;
            }
        }
        return result.next;
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
