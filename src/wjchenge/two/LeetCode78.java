package wjchenge.two;

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
        if (nums == null) return res;
        this.process(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void process(int[] nums, int i, List<List<Integer>> res, ArrayList<Integer> sub) {
        if (i == nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        this.process(nums, i + 1, res, sub);
        sub.remove(sub.size() - 1);
        this.process(nums, i + 1, res, sub);
    }


}
