package topinterview;

public class _371_getSum_medium {
    // 位运算实现加法运算
    public int getSum(int a, int b) {
        // 先用^异或运算得到非进位加法结果
        // 再用&与操作得到进位加法结果，左移一位
        // 重复上述过程，直到进位为0
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

}
