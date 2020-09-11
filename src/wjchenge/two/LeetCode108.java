package wjchenge.two;

/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author wjchenge
 */
public class LeetCode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l == r) return null;
        int min = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[min]);
        root.left = sortedArrayToBST(nums, l, min);
        root.right = sortedArrayToBST(nums, min + 1, r);
        return root;
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
