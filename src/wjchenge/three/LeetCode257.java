package wjchenge.three;


import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * @author wjchenge
 */
public class LeetCode257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        this.binaryTreePaths(root, res, "");
         return res;
    }

    private void binaryTreePaths(TreeNode root, List<String> res, String s) {
        if (root == null) return;
        StringBuilder sb = new StringBuilder(s).append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return;
        }
        sb.append("->");
        binaryTreePaths(root.left, res, sb.toString());
        binaryTreePaths(root.right, res, sb.toString());
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
