package wjchenge.two;

/**
 * 26. 删除排序数组中的重复项
 * @author wjchenge
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int k = 0;//下一个不重复位置
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        return ++k;
    }


}
