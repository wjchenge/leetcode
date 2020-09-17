package wjchenge.two;

/**
 * 606. 根据二叉树创建字符串
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * @author wjchenge
 */
public class LeetCode606 {

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t == null) return "";
        sb.append(t.val);
        String l = tree2str(t.left);
        String r = tree2str(t.right);
        if (l == r) return sb.toString();
        if (l == "") return sb.append("()(").append(r).append(")").toString();
        if (r == "") return sb.append("(").append(l).append(")").toString();
        return sb.append("(").append(l).append(")").append("(").append(r).append(")").toString();
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
