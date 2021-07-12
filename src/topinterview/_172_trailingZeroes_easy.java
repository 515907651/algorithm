package topinterview;

public class _172_trailingZeroes_easy {
    // 朴素想法是求n！的值，然后数0,
    // 进一步想，10都是5*2^来的，数5和2的个数就OK
    // 再进一步，5肯定比2多，直接统计5的个数就行
    // 怎么求1到n有多少个5呢，假若N=31 31里能凑10的5为[5, 2*5, 3*5, 4*5, 25, 6*5]，也就是除以5，看有多少个，再除以5^2，依次类推
    public int trailingZeroes(int n) {
        int ans = 0;
        int temp = 5;
        while (n / temp != 0) {
            ans += n / temp;
            temp *= 5;
        }
        return ans;
    }

}
