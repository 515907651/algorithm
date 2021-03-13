package DP;

import java.util.Arrays;

public class MinCut_132_hard {
    // 两次dp，第一次求出所有回文子串，第二次利用第一次回文子串找最小的分割次数
    public int minCut(String s) {
        if (s==null||s.length()==0) return 0;
        int n = s.length();
        boolean[][] palindromic = new boolean[n][n];
/*
        // 我自己写的这个逻辑可太复杂了，要考虑i+1和j-1的大小
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i==j) palindromic[i][j] = true;
                else {
                    if (s.charAt(i)==s.charAt(j)){
                        if (j-i==1) {
                            palindromic[i][j] = true;
                        } else if (palindromic[i+1][j-1]){
                            palindromic[i][j] = true;
                        }
                    }
                }
            }
        }
*/
        for (int i = 0; i < n; i++) {
            Arrays.fill(palindromic[i],true);
        }
        for (int i = n-1; i > 0; i--) {
            for (int j = i+1; j < n; j++) {
                palindromic[i][j] = s.charAt(i)==s.charAt(j)&&palindromic[i+1][j-1];
                // 这一段比较难理解，习惯性地把i从0涨到n，发现转移方程里需要g[i+1][j-1]，这个时候i+1还没判断，所以要把i从n-1减小到0
            }
        }
/*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                palindromic[i][j] = s.charAt(i)==s.charAt(j)&&palindromic[i+1][j-1];
            }
        }
*/
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
           if (palindromic[0][i]) {
                f[i] = 0;
           } else {
               for (int j = 0; j < i; ++j) {
                   if (palindromic[j + 1][i]) {
                       f[i] = Math.min(f[i], f[j] + 1);
                   }
               }
           }
        }
        return f[n-1];
    }

}
