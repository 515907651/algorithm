package topinterview;

public class _48_Rotate_Medium {
    public void rotate(int[][] matrix) {
        // 我的思路是从外侧开始遍历，每次缩小一圈，感觉代码不好写
        // 简单的思路是将矩阵先水平翻转，再主对角线翻转
        // TODO 写一遍第一种思路
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
