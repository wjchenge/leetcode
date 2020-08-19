package wjchenge.three;

/**
 * 189. 旋转数组
 * @author wjchenge
 */
public class LeetCode189 {

    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return;
        int length = nums.length;
        k = k % length;
        while (k-- > 0) {
            int tmp = nums[length - 1];
            for (int i = length - 1; i > 0;) {
                nums[i] = nums[--i];
            }
            nums[0] = tmp;
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return;
        int length = nums.length;
        k = k % length;
        this.reverse(nums, 0, length - 1);
        this.reverse(nums, 0, k - 1);
        this.reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int tmp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = tmp;
        }
    }

}
