package wjchenge.one;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @author wjchenge
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return serialize(root, list);
    }

    private String serialize(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return Arrays.toString(list.toArray());
        };
        list.add(root.val);
        serialize(root.left, list);
        serialize(root.right, list);
        return Arrays.toString(list.toArray());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 2) return null;
        String[] arr = data.substring(1, data.length() - 1).split(",");

        return null;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Codec().new TreeNode(1);
        treeNode.left = new Codec().new TreeNode(2);
        treeNode.right = new Codec().new TreeNode(3);
        treeNode.right.left = new Codec().new TreeNode(4);
        treeNode.right.right = new Codec().new TreeNode(5);
        System.out.println(new Codec().serialize(treeNode));


    }


}
