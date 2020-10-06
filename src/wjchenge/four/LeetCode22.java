package wjchenge.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @author wjchenge
 */
public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        this.process(n, n, res, "");
        return res;

    }

    private void process(int l, int r, List<String> ret, String s) {
        if (l == 0 && r == 0) {
            ret.add(s);
            return;
        }
        if (l > 0) this.process(l - 1, r, ret, s + "(");
        if (r > l) this.process(l, r - 1, ret, s + ")");
    }

}
