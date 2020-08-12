package wjchenge.two;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * @author wjchenge
 */
public class LeetCode1 {


    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                result[0] = map.get(key);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

}
