package wjchenge.three;

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
        this.process(board, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], 0, res);
        return res;

    }

    private void process(char[][] board, boolean[] col, boolean[] xy_sum, boolean[] xy_dif, int row, List<List<String>> res) {
        int len = board.length;
        if (row == len) {
            res.add(new ArrayList<>(generate(board)));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (col[i] || xy_sum[row + i] || xy_dif[row - i + len - 1]) continue;
            board[row][i] = 'Q';
            col[i] = true;
            xy_sum[row + i] = true;
            xy_dif[row - i + len - 1] = true;
            this.process(board, col, xy_sum, xy_dif, row + 1, res);
            board[row][i] = '.';
            col[i] = false;
            xy_sum[row + i] = false;
            xy_dif[row - i + len - 1] = false;


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
