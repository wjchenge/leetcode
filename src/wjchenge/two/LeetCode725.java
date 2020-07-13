package wjchenge.two;

/**
 * 725. 分隔链表
 * @author wjchenge
 */
public class LeetCode725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        ListNode tmp = root;
        int size = 0;
        while (tmp != null) {
            tmp = tmp.next;
            ++size;
        }
        if (size == 0) return result;
        int subSize = size / k;
        int mod = size % k;
        for (int i = 0; root != null && i < k; i++) {
            size = subSize + (--mod >= 0 ? 0 : -1);
            result[i] = root;
            while (--size >= 0) {
                root = root.next;
            }
            ListNode next = root.next;
            root.next = null;
            root = next;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
