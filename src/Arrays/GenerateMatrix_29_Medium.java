package Arrays;

public class GenerateMatrix_29_Medium {
    // 首先确定有n^2个数字，创建一个n*n的数组，把数字螺旋放入
    // 还是螺旋遍历嘛，只不过从读数字变成了放数字
    // 思路是建立一个遍历数组，判断当前位置是否被访问过
    // Enum类不会用
    // 出现的小问题，边界问题，<n,>=0,<=n*n
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 1) {
            result[0][0] = 1;
            return result;
        }
        boolean[][] visited = new boolean[n][n];
        int direction = 4;
        // 上下左右对应着1234
        int num = 1;
        int i  = 0;
        int j = 0;
        while (num <= n*n){
            if (num == n){

            }
            if (direction == 4) {
                while (j < n && !visited[i][j]){
                    result[i][j] = num;
                    visited[i][j] = true;
                    num++;
                    j++;
                }
                j--;
                i++;
                direction = 2;
            }
            if (direction == 2) {
                while (i < n && !visited[i][j]) {
                    result[i][j] = num;
                    visited[i][j] = true;
                    num++;
                    i++;
                }
                i--;
                j--;
                direction = 3;
            }
            if (direction == 3) {
                while (j >= 0 && !visited[i][j]) {
                    result[i][j] = num;
                    visited[i][j] = true;
                    num++;
                    j--;
                }
                j++;
                i--;
                direction = 1;
            }
            if (direction == 1) {
                while (i >= 0 && !visited[i][j]){
                    result[i][j] = num;
                    visited[i][j] = true;
                    num++;
                    i--;
                }
                i++;
                j++;
                direction = 4;
            }
        }
        return result;
    }

}
