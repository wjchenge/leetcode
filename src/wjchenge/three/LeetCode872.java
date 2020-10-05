package wjchenge.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 * @author wjchenge
 */
public class LeetCode872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        this.preOrder(root1, l1);
        this.preOrder(root2, l2);
        return l1.equals(l2);
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == root.right) list.add(root.val);
        this.preOrder(root.left, list);
        this.preOrder(root.right, list);

    }


    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
