package Arrays;

public class HammingWeight_191_easy {
    public static void main(String[] args) {
        System.out.println(hammingWeight1(00000000000000000000000000001011));
        int n = 00000000000000000000000000001011;
        System.out.println(n);
    }

    private static int hammingWeight(int n) {
        // 用整数类型做好像不太行，转换为字符串试试
        int result = 0;
        while (n != 0) {
            int k = n % 10;
            n = n / 10;
            if (k == 1) result++;
        }
        return result;
    }

    private static int hammingWeight1(int n) {
        // 字符串也不行，淦，用题解的位运算试试
        String s = Integer.toString(n);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') result++;
        }
        return result;
    }

    private static int hammingWeight2(int n) {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask&n)!=0){
                // 位运算符优先级低于!=，要加个括号
                result++;
            }
            mask<<=1;
        }
        return result;
    }

}
