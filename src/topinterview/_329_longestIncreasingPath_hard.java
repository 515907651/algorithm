package topinterview;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class _329_longestIncreasingPath_hard {
    // 再看看，背过吧，写不出来
    // 要记录下重复访问的，进行剪枝
    int max = 0;

    public int longestIncreasingPath1(int[][] matrix) {
        // 先别管别的，特殊情况判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // 用DFS呢还是BFS，肯定是回溯法
        // 肯定还要有一个标记数组，记录下已经去过的位置
        // 因为是单调递增的，根本不需要考虑有没有visit
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dfs1(0, 0, matrix, visited, new LinkedList<Integer>());
            }
        }
        return max;
    }

    private void dfs1(int x, int y, int[][] matrix, boolean[][] visited, LinkedList<Integer> list) {
        int row = matrix.length;
        int column = matrix[0].length;
        if (x < 0 || x >= row || y < 0 || y >= column && visited[x][y]) {
            // 判断合法性
            // 越界或者已经遍历过，直接返回
            return;
        }
        if (list.isEmpty()) {
            // 第一个数字直接加入
            list.add(matrix[x][y]);
            visited[x][y] = true;
        } else
        // 判断当前数字和上一个数字的大小
        if (matrix[x][y] > list.getLast()) {
            list.addLast(matrix[x][y]);
            visited[x][y] = true;
        }
        if (list.size() > max) {
            max = list.size();
        }
        int[] direction = {1, -1};
        // 这种方向是不对的
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                dfs1(x + direction[i], y + direction[i], matrix, visited, list);
                list.remove();
            }
        }

    }

    public int longestIncreasingPath(int[][] matrix) {
        // 特殊情况判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        // 记录下之前去过的最大值
        int[][] mem = new int[row][column];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                ans = Math.max(dfs(matrix, mem, i, j), ans);
            }
        }
        return ans;


    }

    private int dfs(int[][] matrix, int[][] mem, int x, int y) {
        if (mem[x][y] != 0) {
            // 访问过直接返回
            return mem[x][y];
        }
        // 这个mem的增长很难理解
        // 当不为0，也就是没有访问过时，因为自身就算是1个数了，所以++
        mem[x][y]++;
        int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int i = 0; i < direction.length; i++) {
            int row = x + direction[i][0];
            int column = y + direction[i][1];
            if (row >= 0 && column >= 0 && row < matrix.length && column < matrix[0].length && matrix[x][y] < matrix[row][column]) {
                // 这个也好难理解
                // 对于每个位置，他的最长数组长度可以是自身已经记录的，最开始时是1，也可以是他的相邻位置的长度加上他自身的1。
                mem[x][y] = Math.max(mem[x][y], dfs(matrix, mem, row, column) + 1);
            }
        }
        return mem[x][y];
    }

}
