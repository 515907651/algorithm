package topinterview;

import org.junit.Test;

public class _5_LongestPalindrome_medium {
    // 找出最长的回文字串并且返回。
    // 动态规划，状态是当前字符串是否是回文子串，dp[i][j]代表从i到j的字符串，当dp[i + 1][j - 1]为回文子串且s[i] == s[j]的时候为true
    // 初始化条件是i==j的时候肯定是回文子串，
    // 应该先把短的判断完了，再去判断长的
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int maxLength = 0;
        String result = null;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                int k = j + i - 1;
                if (k >= s.length()) {
                    break;
                }
                if (s.charAt(j) != s.charAt(k)) {
                    dp[j][k] = false;
                } else {
                    if (k - j < 3) {
                        dp[j][k] = true;
                    }
                    else {
                        dp[j][k] = dp[j + 1][k - 1];
                    }
                }
                if (dp[j][k] && maxLength <= i) {
                    result = s.substring(j, j + i);
                }
            }
        }
        return result;
    }

    @Test
    public void tempTest() {
        System.out.println(longestPalindrome("acbbbb"));
    }
}
