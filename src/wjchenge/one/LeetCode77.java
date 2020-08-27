package wjchenge.one;

import java.util.*;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * @author wjchenge
 */
public class LeetCode77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (k == 0 || k > n) return ret;
        List<Integer> subList = new ArrayList<>();
        this.combine(1, n, k, ret, subList);
        return ret;
    }

    private void combine(int start, int n, int k, List<List<Integer>> ret, List<Integer> subList) {
        if (k == 0) {
            ret.add(new ArrayList<>(subList));
            return;
        }

        for (int i = start; i <= n; i++) {
            subList.add(i);
            combine(i + 1, n, k - 1, ret, subList);
            subList.remove(subList.size() - 1);
        }
    }

}
