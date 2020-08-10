package wjchenge.one;

/**
 * 26. 删除排序数组中的重复项
 * @author wjchenge
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,2};
        System.out.println(new LeetCode26().removeDuplicates(a));
    }

}
