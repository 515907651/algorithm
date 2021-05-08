package offer;

public class CuttingRope_14_1_medium {
    // 剪绳子，最好分为长度为3的段
    public int cuttingRope(int n) {
        if (n <= 3) {
            // 应该是小于等于，取到3的时候，只能返回2
            return n - 1;
        }
        int temp1 = n / 3;
        int temp2 = n % 3;
        if (temp2 == 1) {
            return (int)Math.pow(3, temp1 - 1) * 4;
        }
        if (temp2 == 2) {
            return (int)Math.pow(3, temp1) * 2;
        }
        if (temp2 == 0) {
            return (int)Math.pow(3, temp1);
        }
        return 1;
    }

}
