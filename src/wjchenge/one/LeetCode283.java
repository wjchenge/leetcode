package wjchenge.one;

/**
 * 移动零
 * @author wjchenge
 */
public class LeetCode283 {

    /**
     * 借助临时数组实现
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int[] tmp = nums.clone();
        int size = nums.length;
        int l = 0;
        int r = size - 1;
        for (int i = 0; i < size; ++i) {
            if (tmp[i] == 0) {
                nums[r--] = tmp[i];
            } else {
                nums[l++] = tmp[i];
            }
        }
    }

    /**
     * 原地排序，先处理非0元素,最后数组补0
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int size = nums.length;
        int k = 0;//非0元素即将插入的位置索引
        for (int i = 0; i < size; i++) {
            if (nums[i] != 0) {
                if (k < i) {
                    nums[k] = nums[i];
                }
                ++k;

            }
        }
        // 补0操作
        for (int i = k; i < size; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 原地排序尽量减少操作次数，只操作非零的数据
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int size = nums.length;
        int k = 0; //记录第一个0元素出现的位置

        for (int i = 0; i < size; ++i) {
            if (nums[i] != 0 && k < i) {
                swap(nums, k++, i);
            } else {
                ++k;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
