package wjchenge.one;

/**
 * 529. 扫雷游戏
 * https://leetcode-cn.com/problems/minesweeper/
 * @author wjchenge
 */
public class LeetCode529 {

    private int[][] move = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0) return board;
        int rowLen = board.length;
        int colLen = board[0].length;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        this.dfs(board, click[0], click[1], rowLen, colLen);

        return board;
    }

    private void dfs(char[][] board, int i, int j, int rowLen, int colLen) {
        if (board[i][j] == 'M') return;
        int num = 0;
        for (int k = 0; k < 8; k++) {
            int nextI = i + move[k][0];
            int nextJ = j + move[k][1];
            if (nextI < 0 || nextJ < 0 || nextI >= rowLen || nextJ >= colLen) continue;
            if (board[nextI][nextJ] == 'M') ++num;
        }
        if (num > 0) {
            board[i][j] = (char) (num + '0');
            return;
        } else {
            board[i][j] = 'B';
        }

        for (int k = 0; k < 8; k++) {
            int nextI = i + move[k][0];
            int nextJ = j + move[k][1];
            if (nextI < 0 || nextJ < 0 || nextI >= rowLen || nextJ >= colLen) continue;
            if (board[nextI][nextJ] != 'E') continue;
            this.dfs(board, nextI, nextJ, rowLen, colLen);
        }


    }


}
