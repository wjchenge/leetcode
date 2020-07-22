package wjchenge.three;

/**
 * 725. 分隔链表
 * @author wjchenge
 */
public class LeetCode725 {


    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int rootSize = 0;
        ListNode tmp = root;
        while (tmp != null) {
            ++rootSize;
            tmp = tmp.next;
        }

        int size = rootSize / k;
        int carry = rootSize % k;
        for (int i = 0; i < k && root != null; i++) {
            int subSize = size + ((carry --) > 0 ? 1 : 0);
            result[i] = root;
            while (subSize-- > 1) {
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
