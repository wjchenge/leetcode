package wjchenge.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 * @author wjchenge
 */
public class LeetCode872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        this.inOrder(root1, list1);
        this.inOrder(root2, list2);
        return list1.equals(list2);
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        this.inOrder(root, list);
        if (root.left == null && root.right == null) list.add(root.val);
        this.inOrder(root, list);

    }


    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
