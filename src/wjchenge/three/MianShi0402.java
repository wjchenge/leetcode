package wjchenge.three;

/**
 * 面试题 04.02. 最小高度树
 * https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 * @author wjchenge
 */
public class MianShi0402 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l >= r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, l, mid);
        root.right = sortedArrayToBST(nums, mid + 1, r);
        return root;
    }


    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
