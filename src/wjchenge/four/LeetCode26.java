package wjchenge.four;

/**
 * 26. 删除排序数组中的重复项
 * @author wjchenge
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return 0;
        int k = 1;
        for (int i = 1; i < len; ++i) {
            if (nums[i] != nums[i - 1]) {
                if (i > k) {
                    nums[k] = nums[i];
                }
                ++k;
            }
        }
        return k;
    }


}
