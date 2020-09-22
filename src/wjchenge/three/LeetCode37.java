package wjchenge.three;

/**
 * 37. 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 * @author wjchenge
 */
public class LeetCode37 {

    private boolean row[][] = new boolean[9][9];
    private boolean col[][] = new boolean[9][9];
    private boolean box[][] = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        this.init(board);
        this.dfs(board);

    }

    private boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (int k = 1; k <= 9 ; k++) {
                    if (!isValid(i, j, k - 1)) continue;
                    board[i][j] = (char) (k + '0');
                    this.fit(i, j, k - 1, true);
                    if (this.dfs(board)) return true;
                    this.fit(i, j, k - 1, false);
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    private void fit(int i, int j, int v, boolean b) {
        row[i][v] = b;
        col[j][v] = b;
        box[i / 3 * 3 + j / 3][v] = b;
    }

    private boolean isValid(int i, int j, int k) {
        if (row[i][k] || col[j][k] || box[i / 3 * 3 + j / 3][k]) return false;
        return true;
    }

    private void init(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int v =  board[i][j] - '1';
                    row[i][v] = true;
                    col[j][v] = true;
                    box[i / 3 * 3 + j / 3][v] = true;
                }
            }
        }
    }

}
