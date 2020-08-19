package wjchenge.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * @author wjchenge
 */
public class LeetCode1 {


    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
