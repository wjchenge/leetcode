package wjchenge.three;

/**
 * 529. 扫雷游戏
 * https://leetcode-cn.com/problems/minesweeper/
 * @author wjchenge
 */
public class LeetCode529 {

    private static final int[][] move = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0) return board;
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }
        int row = board.length;
        int col = board[0].length;
        this.dfs(board, i, j, row, col);
        return board;
    }

    private void dfs(char[][] board, int i, int j, int row, int col) {
        if (!isArea(i, j, row, col)) return;
        int num = 0;
        for (int[] m : move) {
            int nI = i + m[0];
            int nJ = j + m[1];
            if (!isArea(nI, nJ, row, col)) continue;
            if (board[nI][nJ] == 'M') {
                ++num;
            }
        }

        if (num == 0) {
            board[i][j] = 'B';
        } else {
            board[i][j] = (char) (num + '0');
            return;
        }

        for (int[] m : move) {
            int nI = i + m[0];
            int nJ = j + m[1];
            if (!isArea(nI, nJ, row, col) || board[nI][nJ] != 'E') continue;
            this.dfs(board, nI, nJ, row, col);
        }

    }

    private boolean isArea(int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col) return false;
        return true;
    }


}
