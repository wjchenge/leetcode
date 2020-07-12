package wjchenge.one;

/**
 * 725. 分隔链表
 * @author wjchenge
 */
public class LeetCode725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k == 0) return new ListNode[] {root};
        ListNode[] result = new ListNode[k];
        if (root == null) {
            while (k-- > 0) {
                result[k] = null;
            }
        }
        int size = 0;
        ListNode tmpNode = root;
        while (tmpNode != null) {
            ++size;
            tmpNode = tmpNode.next;
        }
        int subSize = size / k;
        int carry = size % k;
        for (int i = 0; root != null && i < k; i++) {
            int tmpSize = subSize +  (--carry) > 0 ? 1 : 0;
            result[i] = root;
            while (--tmpSize >= 0) {
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
