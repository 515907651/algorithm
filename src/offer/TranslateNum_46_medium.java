package offer;

public class TranslateNum_46_medium {
    public int translateNum(int num) {
        // 动态规划
        // 状态是有多少种不同的方法，改变状态的是当前数字是单独翻译还是和前面的一起翻译
        String s = String.valueOf(num);
        char[] chars = String.valueOf(num).toCharArray();
        int length = chars.length;
        int[] dp = new int[length];
        if (length == 1) {
            return 1;
        }
        dp[0] = 1;
        if (Integer.parseInt(s.substring(0,2)) < 26 && Integer.parseInt(s.substring(0,2)) > 10){
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < length; i++) {
            if (Integer.parseInt(s.substring(0,2)) < 26 && Integer.parseInt(s.substring(0,2)) > 10){
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1] ;
            }
        }
        return dp[length-1];
    }

}
