package restart.wjchenge.one;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class Leetcode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode hummyNode = new ListNode(0);
        ListNode node = hummyNode;
        while (!queue.isEmpty()) {
            node.next = queue.poll();
            node = node.next;
            if (node.next != null) queue.add(node.next);
        }

        return hummyNode.next;


    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
