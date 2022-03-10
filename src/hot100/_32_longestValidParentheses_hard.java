package hot100;

public class _32_longestValidParentheses_hard {
    public int longestValidParentheses1(String s) {
        // 动态规划
        // 特殊情况判断
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        // dp代表以下标i为结尾的最长长度，初始化全部为0
        int[] dp = new int[length];
        int max = 0;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')') {
                // 当前是')'，而且左边有相邻的'('
                if (s.charAt(i - 1) == '(') {
                    // dp[i] 等于'('前面的长度+2
                    dp[i] = (i - 2 >= 0 ? dp[i-2] : 0 ) + 2;
                } else if (i - dp[i-1] -1 >= 0 && s.charAt(i - dp[i - 1] - 1) =='('){
                    // 左边是个')'，这时候要去判断i-1对应的'('左边是不是'('
                    dp[i] = dp[i-1] + 2 + (i - dp[i-1] - 2 >= 0 ? dp[i - dp[i-1] - 2] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
