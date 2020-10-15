package wjchenge.four;

import java.util.ArrayList;
import java.util.List;

/**ø
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 * @author wjchenge
 */
public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        this.subsets(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void subsets(int[] nums, int i, List<List<Integer>> res, List<Integer> li) {
        if (i == nums.length) {
            res.add(new ArrayList<>(li));
            return;
        }

        li.add(nums[i]);
        this.subsets(nums, i + 1, res, li);
        li.remove(li.size() - 1);
        this.subsets(nums, i + 1, res, li);
    }


}
