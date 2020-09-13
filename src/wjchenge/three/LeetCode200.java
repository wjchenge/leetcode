package wjchenge.three;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 * @author wjchenge
 */
public class LeetCode200 {

    private static final int[][] move = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid == null || grid.length == 0) return num;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    this.findLands(grid, i, j, row, col);
                    ++num;
                }
            }
        }
        return num;
    }

    private void findLands(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0') return;

        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        }
        for (int[] m : move) {
            this.findLands(grid, i + m[0], j + m[1], row, col);
        }
    }
}
