package wjchenge.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author wjchenge
 */
public class LeetCode105 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return this.buildTree(preorder, 0, preorder.length - 1, map, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pl, int pr, Map<Integer, Integer> map, int il, int ir) {
        if (pr < pl || ir < il) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int rootIndex = map.get(preorder[pl]);
        root.left = buildTree(preorder, pl + 1, rootIndex - il + pl, map, il, rootIndex - 1);
        root.right = buildTree(preorder, rootIndex- il + pl + 1, pr, map, rootIndex + 1, ir);
        return root;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
