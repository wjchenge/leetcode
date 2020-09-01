package wjchenge.one;

import java.util.*;

/**
 * 51. N皇后
 * https://leetcode-cn.com/problems/n-queens/
 * @author wjchenge
 */
public class LeetCode51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;
        char[][] chars = new char[n][n];
        this.initChars(chars);
        this.process(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], res, chars);
        return res;
    }

    private void initChars(char[][] chars) {
        for (char[] sub : chars) {
            Arrays.fill(sub, '.');
        }
    }

    private void process(int row, boolean[] col, boolean[] xy_dif, boolean[] xy_sum, List<List<String>> res, char[][] chars) {
        if (row == chars.length) {
            res.add(generate(chars));
            return;
        }

        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (col[i] || xy_dif[row - i + len - 1] || xy_sum[row + i]) continue;
            col[i] = true;
            xy_dif[row - i + len - 1] = true;
            xy_sum[row + i] = true;
            chars[row][i] = 'Q';
            this.process(row + 1, col, xy_dif, xy_sum, res, chars);
            col[i] = false;
            xy_dif[row - i + len - 1] = false;
            xy_sum[row + i] = false;
            chars[row][i] = '.';

        }

    }

    private List<String> generate(char[][] chars) {
        List<String> res = new ArrayList<>();
        for (char[] sub : chars) {
            StringBuilder str = new StringBuilder();
            for(char c : sub) {
                str.append(c);
            }
            res.add(str.toString());
        }
        return res;
    }


    public static void main(String[] args) {
        new LeetCode51().solveNQueens(4);
    }

}
