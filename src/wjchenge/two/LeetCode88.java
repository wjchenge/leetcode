package wjchenge.two;

/**
 * 88. 合并两个有序数组
 * @author wjchenge
 */
public class LeetCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
            } else if (j < 0) {
                break;
            } else if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
    }

}
