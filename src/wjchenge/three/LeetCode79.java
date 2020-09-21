package wjchenge.three;

/**
 * 79. 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 * @author wjchenge
 */
public class LeetCode79 {

    private static final int[][] move = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (chars[0] == board[i][j]) {
                    if (this.helper(board, chars, i, j, row, col, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, char[] chars, int i, int j, int row, int col, int wordIndex) {
        if (wordIndex == chars.length) return true;
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != chars[wordIndex]) return false;
        board[i][j] ^= 256;
        for (int[] m : move) {
            if (this.helper(board, chars, i + m[0], j + m[1], row, col, wordIndex + 1)) return true;
        }
        board[i][j] ^= 256;
        return false;
    }


}
