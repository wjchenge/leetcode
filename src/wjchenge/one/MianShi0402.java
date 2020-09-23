package wjchenge.one;

/**
 * 面试题 04.02. 最小高度树
 * https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 * @author wjchenge
 */
public class MianShi0402 {

    public TreeNode sortedArrayToBST(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return null;
        return sortedArrayToBST(nums, 0, len);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l >= r) return null;
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, l, mid);
        node.right = sortedArrayToBST(nums, mid + 1, r);
        return node;
    }


    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
