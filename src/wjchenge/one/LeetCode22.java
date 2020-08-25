package wjchenge.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @author wjchenge
 */
public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n < 1) return ret;
        generateParenthesis(n, n, "", ret);
        return ret;
    }

    private void generateParenthesis(int left, int right, String str, List<String> ret) {
        if (left == 0 && right == 0) {
            ret.add(str.toString());
            return;
        }

        if (left > 0) generateParenthesis(left - 1, right, str + "(", ret);
        if (right > left) generateParenthesis(left, right - 1, str + ")", ret);
    }

}
