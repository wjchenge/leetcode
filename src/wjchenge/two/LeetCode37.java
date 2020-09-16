package wjchenge.two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 37. 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 * @author wjchenge
 */
public class LeetCode37 {

    private boolean[][] row = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][] box = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        this.init(board);
        System.out.println(row);
        this.dfs(board);
    }

    private boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        int v = c - '1';
                        if (isValid(i, j, c - '1')) {
                            board[i][j] = c;
                            row[i][v] = true;
                            col[j][v] = true;
                            box[i / 3 * 3 + j / 3][v] = true;
                            if (dfs(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                                row[i][v] = false;
                                col[j][v] = false;
                                box[i / 3 * 3 + j / 3][v] = false;

                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int i, int j, int v) {
        if (row[i][v] || col[j][v] || box[i / 3 * 3 + j / 3][v]) return false;
        return true;
    }

    private void init(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '1';
                    row[i][val] = true;
                    col[j][val] = true;
                    box[i / 3 * 3 + j / 3][val] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        char c = '6';
        int i = c - '1';
        String s = "";
        System.out.println(i);
        System.out.println(s == "");
    }


}
