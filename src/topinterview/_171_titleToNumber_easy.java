package topinterview;

public class _171_titleToNumber_easy {
    // 简简单单26进制
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int ans = 0;
        int temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans += (columnTitle.charAt(i) - 'A' + 1) * temp;
            temp *= 26;
        }
        return ans;
    }

}
