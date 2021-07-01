package topinterview;

public class _121_maxProfit_medium {
    // 买卖股票问题，动态规划
    // 一时间想不起状态是什么了
    // 首先要求的是maxprofit，那么我们就像让买时尽量小，卖时尽量高
    // 记录下当前位置前的最小值，然后求当前位置的利益，求出最大值
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        // max的最小值是0，如果小于0，就不买卖
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i - 1]);
            int profit = prices[i] - dp[i];
            max = Math.max(profit, max);
        }
        return max;
    }
}
