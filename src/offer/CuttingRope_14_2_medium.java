package offer;

public class CuttingRope_14_2_medium {
    // 结果要求对1000000007取模，否则数据越界
    // 这个题还是得再看看，首先为了解决越界要使用long，而且long是要覆盖所有的，再者循环取模
    public int cuttingRope(int n) {
        // 主要思路和代码是一样的，多了个取模运算
        if (n <= 3) {
            return n - 1;
        }
        // 取模运算，modulus
        int modulus = n % 3;
        // 取余运算，remainder
        int remainder = n / 3;
        if (modulus == 1) {
            return (int)(quickPow(3, remainder - 1) * 4 % 1000000007);
        }
        if (modulus == 2) {
            return (int)(quickPow(3, remainder) * 2 % 1000000007);
        }
        if (modulus == 0) {
            return (int)(quickPow(3, remainder) % 1000000007);
        }
        return 1;
    }

    private long quickPow(int i, int i1) {
        long ans = 1;
        for (int j = 0; j < i1; j++) {
            ans = i * ans % 1000000007;
        }
        return ans;
    }
}
