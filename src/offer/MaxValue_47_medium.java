package offer;

public class MaxValue_47_medium {
    public int maxValue(int[][] grid) {
        // 这明显dp啊
        // 按照套路来，首先确定状态，状态是到当前格子能够收获的礼物最大值dp
        // 改变状态的行为是移动，dp[i][j]，也就是i，j的变化
        // 状态转移方程的话就有点麻烦了，毕竟是个二维数组，而且规定只能i++，j++，考虑边界问题
        // 如果是有i-1和j-1的话，dp[i][j] = grid[i][j] + max(dp[i-1][j], dp[i][j-1])
        // 能不能直接把边界给初始化了，只能往下和往右走的话，边界上的值是确定的，等于前面所有的和，机智，那就没有边界判定了
        // 解决边界问题还有一种思路就是多扩一行一列，就不用初始化第一行第一列了
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        // 初始化第一行
        for (int i = 1; i < column; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        // 初始化第一列
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = grid[i][j] + Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[row-1][column-1];
    }
    public int maxValue1(int[][] grid) {
        // 多扩一行一列解决边界问题
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row+1][column+1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = grid[i-1][j-1] + Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[row][column];
    }
}
