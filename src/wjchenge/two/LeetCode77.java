package wjchenge.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * @author wjchenge
 */
public class LeetCode77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (k == 0 || k > n) return ret;
        this.process(1, n, k, ret, new ArrayList<>());
        return ret;
    }

    private void process(int index, int n, int k, List<List<Integer>> ret, ArrayList<Integer> cur) {
        if (cur.size() == k) {
            ret.add(new ArrayList<>(cur));
            return;
        }
        //
        for (int i = index; i <= n - (k - cur.size()) + 1; i++) {
            cur.add(i);
            this.process(i + 1, n, k, ret, cur);
            cur.remove(cur.size() - 1);
        }
    }


}
