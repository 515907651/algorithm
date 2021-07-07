package topinterview;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_wordBreak_medium {
    // 动态规划
    // 看到完全没有思路，而且题意也理解错了
    // 我理解的是，重复利用s中的字符看是否能拼出list中的单词，那直接统计一下字符数量就OK
    // 应该是将s分割，分割后的每个子串都是list中的单词
    // 对于位置i，如果0-i可以分割成list中的单词，就是true，怎么分割呢
    // 在0到i中间一个j，如果0-j可以分割成单词，j-i是单词，那么i就是true
    public boolean wordBreak(String s, List<String> wordDict) {
        // 对于判断是否包含单词，利用set来判断
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        // 初始化状态，为什么不是false，因为字典中默认有空字符
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
