package restart.wjchenge.two;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class Leetcode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, Comparator.comparingInt(v -> v.val));
        for (ListNode node : lists) {
            if (node != null) q.add(node);
        }
        ListNode resNode = new ListNode(0);
        ListNode tmp = resNode;
        while (!q.isEmpty()) {
            ListNode node = q.poll();
            tmp.next = node;
            tmp = tmp.next;
            if (node.next != null) q.add(node.next);
        }
        return resNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
