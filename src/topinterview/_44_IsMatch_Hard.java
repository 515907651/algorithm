package topinterview;

public class _44_IsMatch_Hard {
    public boolean isMatch(String s, String p) {
        // 动态规划，虽然看的云里雾里的，抄一遍再说
        // 总的思路
        // 状态是dp[i][j]，代表字符串s从0到i和字符串p从0到j是否对应
        // 对于当前位置，有三种情况
        // 第一种，s和p都是普通字符，那么当两字符相等且dp[i-1][j-1]为true的时候，dp[i][j]为true
        // 第二种，当p字符为‘?’的时候，如果dp[i-1][j-1]为true，那么dp[i][j]为true
        // 第三种，当p为'*'，这个情况不太明白的，按题解的说法是，可以选择用或者不用这个字符，如果不用，就是从dp[i][j - 1]转换来，如果用
        // 就是从dp[i - 1][j]转换来，
        // 现在面对*，它可以表示空字符，也就是说直接把*去掉，看没有*是否能匹配，即保持i不动，j-1；
        // 另一种情况是*表示多个字符，我们得把*留着，所以j不动，然后看当前字符之前的字符是否也能被*匹配，如果之前字符能，那么再加上现在的一个字符，*就能匹配这几个连续字符了
        // 对于初始化，dp[0][0]代表两字符串都是空的，肯定为true
        // dp[i][0]肯定为false，dp[0][j]如果p是'?'构成的，那么为true；
        // TODO 之后再自己写一变
        if (s == null || p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始化
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            // 只有p的所有字符都是*时，dp[0][i]才为真
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt( i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
            
        }
        return dp[m][n];
    }


}
