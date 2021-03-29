package Arrays;

public class ReverseBits_190_easy {
    // 自己的思路是将数字转换为字符串，然后反转字符串，再按位求值
    // 题解看见个骚的
    public int reverseBits(int n) {
        // 直接调用函数
        return Integer.reverse(n);
    }
    //位运算搞
    public int reverseBits1(int n) {
        int result = 0;
        int i = 32;
        for (int j = 0; j < 32; j++) {
            result <<= 1;
            result += n & 1;
            n >>= 1;
        }
        return result;
    }
    // 位运算交换一下顺序行不行
    // 结果显示不正确，少向左移了一位
    // 不知道为什么，晚会再想
    // 评论区的解释：考虑最后一次循环，如果是先累加再左移，循环一结束最后答案右边始终会多一位0
    // result必须确保下一位还有数
    public int reverseBits2(int n) {
        int result = 0;
        int i = 32;
        for (int j = 0; j < 32; j++) {

            result += n & 1;
            result <<= 1;
            n >>= 1;
        }
        return result;
    }



}
