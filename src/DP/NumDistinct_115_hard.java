package DP;

public class NumDistinct_115_hard {
    // 动态规划，有点难的
    // 首先当s的长度小于t的长度时，可以直接返回0了
    // 做了一遍还是不会，不理解
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        // 为什么要+1
        char temps;
        char tempt;
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
            // 边界，当t的长度为0时，肯定是任何s的子序列
            // 还有一个当s的长度为0时，任何t都不为子序列，为什么没初始化，因为默认就是0
        }
        for (int i = m-1; i >= 0; i--) {
            temps = s.charAt(i);
            for (int j = n-1; j >=0 ; j--) {
                tempt = t.charAt(j);
                if (temps == tempt){
                    // 当前字符相等，下面的操作有两种可能，第一种，选择该字符，那么就是从i+1开始匹配j+1，不选的话i就跳过i，从i+1开始，j没法跳，从j开始
                    dp[i][j] = dp[i+1][j+1] +dp[i+1][j];
                } else {
                    // 当前字符不相等，只能从j开始
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }

}
