package offer;

public class MyPow_16_medium {
    // 快速幂
    public double myPow(double x, int n) {
        // 首先n变成整数，当n是负数的时候，x要变成1/x
        double result = 1.0;
        if (n == 0) {
            return 1.0;
        }
        if (x == 0) {
            return 0;
        }
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                // 如果n是个奇数
                result *= x;
            }
            x *= x;
            n >>= 1;
        }
        return result;
    }

}
