package wjchenge.four;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * @author wjchenge
 */
public class LeetCode1 {


    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

}
