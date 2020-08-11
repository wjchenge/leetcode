package wjchenge.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * @author wjchenge
 */
public class LeetCode1 {

    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

}
