package DP;

public class ClimbStairs {
    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    public static int climbStairs(int n){
        int a = 1;
        int b = 2;
        int c =a+b;
        if(n<=0) return 0;
        if(n==1) return a;
        if(n==2) return b;
        for(int i=3;i<=n;i++){
            c = a+b;
            a=b;
            b=c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
