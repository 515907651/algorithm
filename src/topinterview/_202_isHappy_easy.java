package topinterview;

public class _202_isHappy_easy {
    // 张飞：你快勒马
    // 刘备：我快乐NMLGB
    // 看到这个题只会求各位平方和，不会判断什么时候不是快乐数
    // 如果不是快乐数，那么一定会形成环，也就是平方和等于之前求过的平方和
    // 这种环可以用快慢指针来做
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int low = n;
        int fast = n;
        do {
            low = squareSum(low);
            fast = squareSum(fast);
            fast = squareSum(fast);
        } while (low != fast);
        // 1的平方和还是1，所以当fast=1的时候就会停下
        return low==1;
    }

    private int squareSum(int n) {
        int ans = 0;
        while (n != 0) {
            ans += Math.pow(n % 10, 2);
            n /= 10;
        }
        return ans;
    }

}
