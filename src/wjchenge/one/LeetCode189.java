package wjchenge.one;

/**
 * 189. 旋转数组
 * @author wjchenge
 */
public class LeetCode189 {

    public void rotate1(int[] nums, int k) {
        if (nums == null || k == 0) return;
        int size = nums.length;
        k %= size;
        while (k-- > 0) {
            int end = nums[size - 1];
            for (int i = size - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = end;
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums == null || k == 0) return;
        int begin = 0;
        int end = nums.length - 1;
        k %= nums.length;
        this.reverse(nums, begin, end);
        this.reverse(nums, begin, k - 1);
        this.reverse(nums, k, end);

    }

    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int tmp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = tmp;
        }
    }

}
