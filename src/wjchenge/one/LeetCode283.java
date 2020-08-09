package wjchenge.one;

/**
 * 283. 移动零
 * @author wjchenge
 */
public class LeetCode283 {

    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        int j = 0;//下一个非零元素的位置
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                ++j;
            }
        }
    }

}
