package wjchenge.one;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 * @author wjchenge
 */
public class LeetCode200 {

    private int[][] move = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid == null || grid.length == 0) return 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    ++num;
                    this.dfs(grid, i, j, rowLen, colLen);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j, int rowLen, int colLen) {
        if (i < 0 || j < 0 || i >= rowLen || j >= colLen) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            this.dfs(grid, i + move[k][0], j + move[k][1], rowLen, colLen);
        }
    }


}
