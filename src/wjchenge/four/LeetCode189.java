package wjchenge.four;

/**
 * 189. 旋转数组
 * @author wjchenge
 */
public class LeetCode189 {

    public void rotate1(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0 || k == 0) return;
        k = k % len;
        for (int i = 0; i < k; ++i) {
            int last = nums[len - 1];
            for (int j = len - 1; j > 0; --j) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }
    }

    public void rotate2(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0 || k == 0) return;
        k = k % len;
        int count = 0;
        for (int i = 0; count < len; i++) {
            int begin = i;
            int pre = nums[begin];
            do {
                int next = (begin + k) % len;
                int tmp = nums[next];
                nums[next] =  pre;
                pre = tmp;
                begin = next;
                ++count;
            } while (begin != i);
        }
    }

    public void rotate3(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0 || k == 0) return;
        k = k % len;
        this.reverse(nums, 0, len - 1);
        this.reverse(nums, 0, k - 1);
        this.reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }

}
