package wjchenge.four;

/**
 * 725. 分隔链表
 * @author wjchenge
 */
public class LeetCode725 {


    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int size = 0;
        ListNode tmpNode = root;
        while (tmpNode != null) {
            ++size;
            tmpNode = tmpNode.next;
        }

        int subSize = size / k;
        int carry = size % k;
        for (int i = 0; i < k && root != null; i++) {
            size = subSize + (carry-- > 0 ? 1 : 0);
            result[i] = root;
            while (root != null && size-- > 1) {
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
