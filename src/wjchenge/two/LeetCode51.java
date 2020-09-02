package wjchenge.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N皇后
 * https://leetcode-cn.com/problems/n-queens/
 * @author wjchenge
 */
public class LeetCode51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1) return res;
        char[][] board = new char[n][n];
        this.initBoard(board);
        this.process(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], res, board);
        return res;
    }

    private void process(int row, boolean[] col, boolean[] xy_dif, boolean[] xy_sum, List<List<String>> res, char[][] board) {

        int len = board.length;
        if (row == len) {
            res.add(generate(board));
        }

        for (int i = 0; i < len; i++) {
            if (col[i] || xy_dif[row - i + len - 1] || xy_sum[row + i]) continue;
            board[row][i] = 'Q';
            col[i] = true;
            xy_dif[row - i + len - 1] = true;
            xy_sum[row + i] = true;
            this.process(row + 1,  col, xy_dif, xy_sum, res, board);
            board[row][i] = '.';
            col[i] = false;
            xy_dif[row - i + len - 1] = false;
            xy_sum[row + i] = false;
        }

    }

    private List<String> generate(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            res.add(new String(chars));
        }
        return res;
    }

    private void initBoard(char[][] board) {
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
    }


}
