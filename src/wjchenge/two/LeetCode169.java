package wjchenge.two;

/**
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 * @author wjchenge
 */
public class LeetCode169 {


    public int majorityElement(int[] nums) {
        int res = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                res = nums[i];
                cnt = 1;
            } else if (nums[i] == res) {
                ++cnt;
            } else {
                --cnt;
            }
        }
        return res;
    }

}
