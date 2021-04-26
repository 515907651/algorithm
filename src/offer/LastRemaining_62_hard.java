package offer;

public class LastRemaining_62_hard {
    public int lastRemaining(int n, int m) {
        int answer = 0;
        answer = f(n,m);
        return answer;
    }

    private int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    // 迭代法
    public int lastRemaining1(int n, int m) {
        // 思路是这样的
        // 首先正着推演，对于第一个要删除的数字，他的位置是m % n
        // 对于第二个，因为要从上次删除的地方开始往后找第m个，所以他的位置是(m % n + 1) % (n - 1)
        // 妈的，推不明白，直接背吧
        // 反着推
        // 最后剩下一个，下标肯定是0
        // 那么反推他在上一次的位置，x = (0 + m) % 2，解释一下，就是补上m个位置，然后对上次的数组长度取模
        // 再上一次，(x + m) % 3
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

}
