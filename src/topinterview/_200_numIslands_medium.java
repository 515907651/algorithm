package topinterview;

import java.util.Deque;
import java.util.LinkedList;

public class _200_numIslands_medium {
    // 广度优先搜索和深度优先搜索，广度我比较熟悉，思路也有，深度的还是得再看看

    public int numIslands(char[][] grid) {
        // 广度，遍历所有位置，当当前位置为1时，岛屿数量++，进行广度优先搜索，并将搜索到的位置标记为0
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                ans++;
                Deque<int[]> queue = new LinkedList<>();
                grid[i][j] = '0';
                queue.offer(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] temp = queue.pop();
                    int tempRow = temp[0];
                    int tempColumn = temp[1];
                    // grid[tempRow][tempColumn] = '0';在这里标记会超时，为什么？
                    if (tempRow + 1 < row && grid[tempRow + 1][tempColumn] == '1') {
                        queue.offer(new int[]{tempRow + 1, tempColumn});
                        grid[tempRow + 1][tempColumn] = '0';
                    }
                    if (tempRow - 1 >= 0 && grid[tempRow - 1][tempColumn] == '1') {
                        queue.offer(new int[]{tempRow - 1, tempColumn});
                        grid[tempRow - 1][tempColumn] = '0';

                    }
                    if (tempColumn + 1 < column && grid[tempRow][tempColumn + 1] == '1') {
                        queue.offer(new int[]{tempRow, tempColumn + 1});
                        grid[tempRow][tempColumn + 1] = '0';
                    }
                    if (tempColumn - 1 >= 0 && grid[tempRow][tempColumn - 1] == '1') {
                        queue.offer(new int[]{tempRow, tempColumn - 1});
                        grid[tempRow][tempColumn - 1] = '0';
                    }
                }
            }
        }
        return ans;
    }
    public int numIslands1(char[][] grid) {
        // dfs，我之前写的dfs太丑陋了，要向题解看齐
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i , j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        // 太优美了
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }


}
