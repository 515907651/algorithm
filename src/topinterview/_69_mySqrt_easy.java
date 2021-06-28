package topinterview;

import org.junit.Test;

public class _69_mySqrt_easy {
    // 二分法查找最大平方根，也就是k^2<=x的最大k值
    // 有点像找右边界
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            // 这里的边界
            int mid = left + (right - left) / 2;
            // long temp = mid * mid;
            if ((long) mid * mid <= x) {
                // 这个地方的越界问题
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    @Test
    public void tempTest() {
        long temp = 0;
        int mid = 2147395599;
        temp = (long)mid*mid;
        System.out.println(temp);
    }
}
