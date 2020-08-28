package wjchenge.two;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.*;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @author wjchenge
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ret = new StringBuilder();
        if (root == null) return "";
        this.serialize(root, ret);
        return ret.substring(0, ret.length() - 1);
    }

    private void serialize(TreeNode root, StringBuilder ret) {
        if (root == null) {
            ret.append("#").append(",");
            return;
        }
        ret.append(root.val).append(",");
        this.serialize(root.left, ret);
        this.serialize(root.right, ret);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        return this.deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    private TreeNode deserialize(Queue<String> data) {
       String val = data.poll();
       if ("#".equals(val)) return null;
       TreeNode node = new TreeNode(Integer.parseInt(val));
       node.left = deserialize(data);
       node.right = deserialize(data);
       return node;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
