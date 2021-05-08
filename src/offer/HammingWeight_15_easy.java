package offer;

public class HammingWeight_15_easy {
    // 位运算，考察&和>>
    // 注意区分>>和>>>，前者是有符号移动，我理解的是负数前面会补1，正数补0，所以需要无符号用>>>
    public int hammingWeight(int n) {
        // 每次判断最后一个是不是1
        int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n = n >> 1;
        }
        return ans;
    }
    public int hammingWeight1(int n) {
        // 每次消去最右边的1
        int ans = 0;
        while (n != 0) {
            ans++;
            n &= n - 1;
        }
        return ans;
    }
}
