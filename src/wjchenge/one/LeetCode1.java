package wjchenge.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author wjchenge
 */
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int size = nums.length;
        for (int i = 0; i < size; ++i) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
