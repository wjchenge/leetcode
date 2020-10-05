package wjchenge.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * @author wjchenge
 */
public class LeetCode47 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        Arrays.sort(nums);
        this.process(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;

    }

    private void process(int[] nums, List<List<Integer>> ret, ArrayList<Integer> cur, boolean[] visited) {
        if (cur.size() == nums.length) {
            ret.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) continue;
            cur.add(nums[i]);
            visited[i] = true;
            this.process(nums, ret, cur, visited);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }

    }
}
