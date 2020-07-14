package wjchenge.three;

/**
 * 167. 两数之和 II - 输入有序数组
 * @author wjchenge
 */
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] restult = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                restult[0] = ++i;
                restult[1] = ++j;
                break;
            } else if (sum < target) {
                ++i;
            } else {
                --j;
            }
        }
        return restult;

    }


}
