package offer;

public class DicesProbability_60_medium {
    // 求六种点数的概率，random？
    public double[] dicesProbability(int n) {
        // 动态规划啊
        // dp[i][j]，i是第几个色子，j是点数
        // 对于第i个骰子，可能出现的点数是1-6，所以，j的值由dp[i][j-(1~6)]决定
        // 最后除以所有可能出现的次数，即6^n
        double sum = Math.pow(6, n);
        // 如果不加一怎么写
        int[][] dp = new int[n + 1][6 * n + 1];
        // 初始化
        // 对于i = 1，出现的点数1-6的次数都是1
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j =i; j <= 6 * i; j++) {
                // j从i开始，举个例子，第二个骰子最小点数是2，要加上之前第一个的点数，结尾是12，也就是6*i
                for (int k = 1; k <= 6 && k <= j; k++) {
                    // k <= j，因为下面j-k必须大于0，为什么能取到j呢，此时j-k==0
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double[] result = new double[5 * n + 1];
        for (int i = n; i < 6 * n + 1; i++) {
            result[i - n] = dp[n][i] / sum;
        }
        return result;
    }

}
