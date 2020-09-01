package wjchenge.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 * @author wjchenge
 */
public class LeetCode169 {

    public int majorityElement(int[] nums) {
        int res = nums[0];
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            if (++count > max) {
                res = nums[i];
                max = count;
            }
            if (count == nums.length / 2) return res;
            map.put(nums[i], count);
        }
        return res;
    }


    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] nums) {
        int val = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                val = num;
                count = 1;
                continue;
            }
            if (val == num) {
                ++count;
            } else {
                --count;
            }

        }
        return val;
    }

}
