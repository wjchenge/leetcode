package wjchenge.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  15. 三数之和
 *  https://leetcode-cn.com/problems/3sum/
 * @author wjchenge
 */
public class LeetCode15 {

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//方便去重
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);//方便去重
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            int sum = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) ++l;
                    while (l < r && nums[r] == nums[r - 1]) --r;
                    ++l;
                    --r;
                } else if (nums[l] + nums[r] < sum) {
                    ++l;
                } else {
                    --r;
                }
            }
        }

        return result;

    }

}
