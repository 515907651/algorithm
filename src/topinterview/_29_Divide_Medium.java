package topinterview;

public class _29_Divide_Medium {
    /**
     * 思路是(被除数-余数)÷除数=商
     * 可以推出
     * 商×除数+余数=被除数
     * 利用位运算模拟
     * 要考虑到很多特殊情况，比如被除数为0，被除数是最小值，除数是-1，那么结果是最大值
     * */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // 判断正负号，这里只需要判断是否异号就可以
        boolean positive = true;
        if ((dividend ^ divisor) < 0) {
            positive = false;
        }
        // 将两数转换为正数，并且类型为long
        long t = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        int result = 0;
        // 从大的数逐渐逼近
        for (int i = 31; i >= 0; i--) {
            if ((t>>i) >= d) {
                // 找到第一个大于等于d的数，即t-2^i*d > 0
                result += 1 << i;
                t -= d << i;
            }
        }
        return positive ? result : -result;
    }

}
