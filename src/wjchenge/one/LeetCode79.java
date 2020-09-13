package wjchenge.one;

/**
 * 79. 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 * @author wjchenge
 */
public class LeetCode79 {

    private static final int[][] move = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

//    public boolean exist(char[][] board, String word) {
//        char[] chars = word.toCharArray();
//        int row = board.length;
//        int col = board[0].length;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                boolean b = this.dfs(board, chars, 0, i, j, row, col, new boolean[row][col]);
//                if (b) return b;
//
//            }
//        }
//        return false;
//
//    }
//
//    private boolean dfs(char[][] board, char[] chars, int w, int i, int j, int row, int col, boolean[][] visited) {
//        if (w == chars.length) return true;
//        if (i < 0 || j < 0 || i >= row || j >= col) return false;
//        for (int[] m : move) {
//            if (board[i][j] == chars[w]) {
//                board[i][j] ^= '#';
//                boolean b = this.dfs(board, chars, w + 1, i + m[0], j + m[1], row, col, visited);
//                if (b) return b;
//                board[i][j] ^= '#';
//            }
//        }
//        return false;
//    }

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, chs, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int idx, int x, int y) {
        if (idx == words.length) {
            return true;
        }
        if (x < 0 || x == board.length || y < 0 || y == board[0].length) {
            return false;
        }
        if (board[x][y] != words[idx]) {
            return false;
        }
        board[x][y] ^= 256;
        for (int[] m : move) {
            boolean b = dfs(board, words, idx + 1, x + m[0], y + m[1]);
            if (b) return b;
        }
        board[x][y] ^= 256;
        return false;
    }



}
