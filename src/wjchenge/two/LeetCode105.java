package wjchenge.two;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author wjchenge
 */
public class LeetCode105 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, 0, inorder.length - 1, preorder, inorder, map);

    }

    private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> map) {
        if (preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = map.get(preorder[preStart]);
        root.left = buildTree(preStart + 1, inStart, rootIndex - 1, preorder, inorder, map);
        root.right = buildTree(preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd, preorder, inorder, map);
        return root;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
