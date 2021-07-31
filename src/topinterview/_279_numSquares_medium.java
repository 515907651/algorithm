package topinterview;

public class _279_numSquares_medium {
    // 动态规划，想不出来哦
    // dp[i]代表数值为i时，平方和为i的最少数字个数
    // dp[i] = min(dp[i-j*j] + 1, dp[i])是转移方程，对于当前数字i，他的dp最小值是一个减去平方和的数字+1或者他本身
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            // 最坏情况是只能由1构成
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                // 从1开始遍历，如果i可以减去一个平方和，那么更新dp
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
