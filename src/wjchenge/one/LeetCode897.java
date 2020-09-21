package wjchenge.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序查找树
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * @author wjchenge
 */
public class LeetCode897 {

    private TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(0);
        cur = res;
        this.inOrder(root);
        return res.right;
    }

//    private void inOrder(TreeNode root) {
//        if (root == null) return;
//        this.inOrder(root.right);
//        root.right = res;
//        res = root;
//        this.inOrder(root.left);
//        root.left = null;
//    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        this.inOrder(root.left);
        cur.right = root;
        cur = root;
        root.left = null;
        this.inOrder(root.right);
    }


    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
