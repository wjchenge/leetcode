package wjchenge.one;

/**
 * 167. 两数之和 II - 输入有序数组
 * @author wjchenge
 */
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{++i, ++j};
            } else if (sum < target) {
                ++i;
            } else {
                --j;
            }
        }
        return null;

    }


}
