package topinterview;

import java.util.Arrays;

public class _322_coinChange_medium {
    // 记得算法课上学过，当时就不会做，这么长时间过去了，应该会了
    public int coinChange(int[] coins, int amount) {
        // 经典的动态规划
        // dp[i]代表面值为i所需最少的货币
        // 状态转移，dp[i] = min(dp[i-n] + 1)
        // 没考虑不能成功的情况，比如[2],3
        // 难点在判断不能成功的情况，初始化所有值为amount+1
        if (coins == null || coins.length == 0) {
            return -1;
        }
        // 这里是不是要+1啊
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        int n = coins.length;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    // 如果不能凑成的话，dp[i]>amount+1
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
