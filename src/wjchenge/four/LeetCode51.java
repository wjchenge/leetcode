package wjchenge.four;

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
        if (n < 0) return res;
        char[][] board = new char[n][n];
        initBoard(board);
        this.solveNQueens(board, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], 0, res);
        return res;
    }

    private void solveNQueens(char[][] board, boolean[] cols, boolean[] xy_sum, boolean[] xy_dif, int rowIndex, List<List<String>> res) {
        int len = board.length;
        if (len == rowIndex) {
            res.add(this.generate(board));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (cols[i] || xy_sum[rowIndex + i] || xy_dif[rowIndex - i + len - 1]) continue;
            board[rowIndex][i] = 'Q';
            cols[i] = true;
            xy_sum[rowIndex + i] = true;
            xy_dif[rowIndex - i + len - 1] = true;
            this.solveNQueens(board, cols, xy_sum, xy_dif, rowIndex + 1, res);
            board[rowIndex][i] = '.';
            cols[i] = false;
            xy_sum[rowIndex + i] = false;
            xy_dif[rowIndex - i + len - 1] = false;
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
