package wjchenge.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  15. 三数之和
 *  https://leetcode-cn.com/problems/3sum/
 * @author wjchenge
 */
public class LeetCode15 {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int sum = 0 - nums[i];
            int l = i + 1;
            int r = length - 1;
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
