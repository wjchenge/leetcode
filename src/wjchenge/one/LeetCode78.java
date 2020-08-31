package wjchenge.one;

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
        this.process(nums, 1, res, new ArrayList<>());
        return res;
    }

    private void process(int[] nums, int i, List<List<Integer>> res, ArrayList<Integer> list) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        this.process(nums, i + 1, res, list);
        list.add(nums[i]);
        this.process(nums, i + 1, res, list);
        list.remove(list.size() - 1);
    }


}
