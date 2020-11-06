package restart.wjchenge.two;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class Offer27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        this.mirrorTree(root.left);
        this.mirrorTree(root.right);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
