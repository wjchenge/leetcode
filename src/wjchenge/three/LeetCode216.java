package wjchenge.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * @author wjchenge
 */
public class LeetCode216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0) return res;
        this.combinationSum3(k, n, 1, res, new ArrayList<>());
        return res;
    }

    private void combinationSum3(int k, int n, int i, List<List<Integer>> res, ArrayList<Integer> li) {
        if (k < 0 || n < 0) return;
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(li));
            return;
        }
        for (; i <= 9; ++i) {
            if (n - i >= 0) {
                li.add(i);
                this.combinationSum3(k - 1, n - i, i + 1, res, li);
                li.remove(li.size() - 1);
            }
        }
    }


}
