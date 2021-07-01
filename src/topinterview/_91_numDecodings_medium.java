package topinterview;

public class _91_numDecodings_medium {
    /**
    * 一眼动态规划*/
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 1;
        }
        int n = s.length();
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i <= n; i++) {
            // 单个的要判断是否为0,0不代表字母
            if (s.charAt(i - 1) != '0'){
                num[i] += num[i - 1];
            }
            // 多个要判断大小是否在26之内
            // 这个前两位要乘10
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 26) {
                num[i] += num[i - 2];
            }
        }
        return num[n];
    }

}
