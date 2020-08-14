package wjchenge.four;

/**
 * 167. 两数之和 II - 输入有序数组
 * @author wjchenge
 */
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{++l, ++r};
            } else if (sum < target) {
                ++l;
            } else {
                --r;
            }
        }
        return null;
    }


}
