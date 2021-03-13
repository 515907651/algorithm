package DP;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths1(m-1,n-1));
    }
    private static int uniquePaths(int m, int n){
        int[][] fun = new int[m][n];
        for (int i = 0; i < m; i++) {
            fun[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            fun[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                fun[i][j] = fun[i-1][j] + fun[i][j-1];
            }
        }
        return fun[m-1][n-1];
    }
    private static int uniquePaths1(int m, int n){
        if(m==0||n==0){
            return 1;
        }
        int result = uniquePaths1(m-1,n)+uniquePaths1(m,n-1);
        return result;
    }
}
