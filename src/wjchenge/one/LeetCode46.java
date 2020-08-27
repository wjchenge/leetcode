package wjchenge.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 * @author wjchenge
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null) return ret;
        this.permute(nums, ret, new ArrayList<>(), new boolean[nums.length]);
        return ret;
    }

    private void permute(int[] nums, List<List<Integer>> ret, List<Integer> cur, boolean[] visited) {
        if (cur.size() == nums.length) {
            ret.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            cur.add(nums[i]);
            visited[i] = true;
            permute(nums, ret, cur, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }

}
