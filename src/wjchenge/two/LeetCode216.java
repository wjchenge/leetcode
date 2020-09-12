package wjchenge.two;

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
        this.combinationSum3(k, n, 1, res, new ArrayList<>());
        return res;

    }

    private void combinationSum3(int k, int n, int i, List<List<Integer>> res, ArrayList<Integer> cur) {
        if (k < 0) return;
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (; i <= 9; ++i) {
            if (i <= n) {
                cur.add(i);
                this.combinationSum3(k - 1, n - i, i + 1, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }


}
