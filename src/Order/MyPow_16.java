package Order;

public class MyPow_16 {
    public static void main(String[] args) {
        // 思路
        // 要考虑到n可能为负数，当为负数的时候 result = 1/result，倒数就完事了
        //
        System.out.println(myPow3(2,11));
    }
    private static double myPow(double x, int n){
        // 那我可真是太强了
        return Math.pow(x,n);
    }
    private static double myPow1(double x, int n){
        // 傻瓜式
        // 一个一个去乘
        if (n==0) return 1;
        double result = 1;
        int k = Math.abs(n);
        for (int i = 0; i < k; i++) {
            result *= x;
        }
        return n>0?result:(1/result);
    }
    private static double myPow2(double x, int n){
        // 快速幂，居然念mi！我念了20年min了
        // 对于幂n，每次除以2
        // 递归算法
        return n>0?quickMul1(x,n):1/quickMul1(x,-n);
    }
    private static double quickMul1(double x, int n){
        if (n==0) return 1;
        double y = quickMul1(x,n/2);
        return n%2==0?y*y:y*y*x;
    }
    private static double quickMul2(double x, int n){
        // 思路
        // 将N每次除以二，当余数为1时说明这次需要多乘一个2，然后越靠前的2后面乘2的次数越多
        // 啊，还是理解不好，再多看几遍题解吧
        double result = 1;
        double X = x;
        int N = n;

        while(N>0){
            if (N%2==1){
                result *= X;
            }
            X *= X;
            N /= 2;
        }
        return result;

    }
    private static double myPow3(double x, int n){
        // 快速幂，居然念mi！我念了20年min了
        // 对于幂n，每次除以2
        // 递归算法
        return n>0?quickMul2(x,n):1/quickMul2(x,-n);
    }



}
