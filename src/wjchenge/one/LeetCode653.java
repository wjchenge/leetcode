package wjchenge.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 653. 两数之和 IV - 输入 BST
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * @author wjchenge
 */
public class LeetCode653 {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        if (list.isEmpty()) return false;
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (list.get(l) + list.get(r) == k) {
                return true;
            } else if (list.get(l) + list.get(r) < k) {
                ++l;
            } else {
                --r;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
