package wjchenge.one;

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
        this.combinationSum3(k, n, res, new ArrayList<>(), 1);
        return res;
    }

    private void combinationSum3(int k, int n, List<List<Integer>> res, List<Integer> es, int i) {
        if (k < 0) return;
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(es));
            return;
        }

        for (; i <= 9 ; i++) {
            if (i <= n) {
                es.add(i);
                combinationSum3(k - 1, n - i, res, es, i + 1);
                es.remove(es.size() - 1);
            }
        }
    }

}
