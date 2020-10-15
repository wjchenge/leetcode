package wjchenge.four;

import java.util.Arrays;

/**
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 * @author wjchenge
 */
public class LeetCode169 {


    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        int res = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                res = nums[i];
                cnt = 1;
            } else if (res == nums[i]) {
                ++cnt;
            } else {
                --cnt;
            }
        }
        return res;

    }


}
