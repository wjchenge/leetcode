package wjchenge.one;

import java.util.*;

/**
 * 37. 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 * @author wjchenge
 */
public class LeetCode37 {

    private List<Set<Character>> rowSet = new ArrayList<>(9);
    private List<Set<Character>> colSet = new ArrayList<>(9);
    private List<Set<Character>> boxSet = new ArrayList<>(9);

    public void solveSudoku(char[][] board) {
        initSet(board);
        this.dfs(board);
    }

    private boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(c, i , j)) {
                            board[i][j] = c;
                            rowSet.get(i).add(c);
                            colSet.get(j).add(c);
                            boxSet.get(i / 3 * 3 + j / 3).add(c);
                            if (dfs(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                                rowSet.get(i).remove(c);
                                colSet.get(j).remove(c);
                                boxSet.get(i / 3 * 3 + j / 3).remove(c);

                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char k, int i, int j) {
        if (rowSet.get(i).contains(k) || colSet.get(j).contains(k) || boxSet.get(i / 3 * 3 + j / 3).contains(k)) return false;
        return true;
    }

    private void initSet(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (rowSet.size() == i) rowSet.add(new HashSet<>());
                if (colSet.size() == j) colSet.add(new HashSet<>());
                if (boxSet.size() == i / 3 * 3 + j / 3) boxSet.add(new HashSet<>());
                rowSet.get(i).add(board[i][j]);
                colSet.get(j).add(board[i][j]);
                boxSet.get(i / 3 * 3 + j / 3).add(board[i][j]);
            }
        }
    }

}
