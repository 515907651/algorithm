package topinterview;

import org.junit.Test;

public class _204_countPrimes_easy {
    // 就一求质数
    public int countPrimes(int n) {
        int ans = 0;
/*
        while (n > 2) {
            if (isPrime(n - 1)) {
                ans++;
            }
            n--;
        }
*/
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isPrime(int i) {
/*
        if (i == 2) {
            return true;
        }
*/
        for (int j = 2; j*j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void Test(){
        System.out.println(countPrimes(2));
    }
}
