package wjchenge.two;

/**
 * 529. 扫雷游戏
 * https://leetcode-cn.com/problems/minesweeper/
 * @author wjchenge
 */
public class LeetCode529 {

    private static final int[][] verify = new int[][] {{-1, -1}, {-1, 0},
            {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1} };

    private static final int[][] move = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0) return board;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        this.dfs(board, click[0], click[1], board.length, board[0].length);

        return board;
    }

    private void dfs(char[][] board, int i, int j, int rowLen, int colLen) {
        if (!isArea(i, j, rowLen, colLen) || board[i][j] != 'E') return;
        if (board[i][j] == 'M') return;
        int num = 0;
        for (int[] m : verify) {
            if (!isArea(i + m[0], j + m[1], rowLen, colLen)) continue;
            if (board[i + m[0]][j + m[1]] == 'M') ++num;
        }

        if (num > 0) {
            board[i][j] = (char) (num + '0');
            return;
        } else {
            board[i][j] = 'B';
        }
        for (int[] m : move) {
            this.dfs(board, i + m[0], j + m[1], rowLen, colLen);
        }

    }

    private boolean isArea (int i, int j, int rowLen, int colLen) {
        if (i < 0 || j < 0 || i >= rowLen || j >= colLen) return false;
        return true;
    }


}
