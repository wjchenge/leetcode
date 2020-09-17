package wjchenge.four;

import java.util.Arrays;

/**
 * 283. 移动零
 * @author wjchenge
 */
public class LeetCode283 {

    public static void moveZeroes(int[] nums) {
        if (nums == null) return;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > k) {
                    nums[k] = nums[i];
                    nums[i] = 0;
                }
                ++k;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,0};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }

}
