package topinterview;

public class _122_maxProfit_easy {
    // 经典买卖股票，不限定次数
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
    public int maxProfit1(int[] prices) {
        // 常量空间
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int n = prices.length;
        // 不持有
        int dp1 = 0;
        // 持有
        int dp2 = -prices[0];
        for (int i = 1; i < n; i++) {
            int temp1 = Math.max(dp1, dp2 + prices[i]);
            int temp2 = Math.max(dp2, dp1 - prices[i]);
            dp1 = temp1;
            dp2 = temp2;
        }
        return dp1;
    }


}
