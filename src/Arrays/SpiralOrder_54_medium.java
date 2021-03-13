package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder_54_medium {
    // 什么时候结束啊，当四个方向的数字全都遍历过结束？或者设置一个n记录访问过的节点数量
    // 新建一个和矩阵大小相同的判断矩阵，记录矩阵中走过的位置
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix[0] == null || matrix[0].length == 0) return result;
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[][] traveled = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            Arrays.fill(traveled[i], true);
        }
        int n = 0;
        int total = row * column;
        int i = 0;
        int j = 0;
        int direction = 4;
        // 1-4，上下左右
        while (n < total) {
            if (direction == 4) {
                // 向右动，i不变，j++到边界
                while (j < column && traveled[i][j]) {
                    n++;
                    result.add(matrix[i][j]);
                    traveled[i][j] = false;
                    j++;
                }
                j--;
                // j已经越界了
                direction = 2;
                i++;
                // 这里要转到下一个没有被访问到的地方
            }
            if (direction == 2) {
                // 向下动，j不变，i++到边界
                while (i < row && traveled[i][j]) {
                    n++;
                    result.add(matrix[i][j]);
                    traveled[i][j] = false;
                    i++;
                }
                i--;
                direction = 3;
                j--;
            }
            if (direction == 3) {
                // 向左动，i不变，j--到边界
                while (j >= 0 && traveled[i][j]) {
                    n++;
                    result.add(matrix[i][j]);
                    traveled[i][j] = false;
                    j--;
                }
                j++;
                direction = 1;
                i--;
            }

            if (direction == 1) {
                // 向上动，j不变，i--到边界
                while (i >= 0 && traveled[i][j]) {
                    n++;
                    result.add(matrix[i][j]);
                    traveled[i][j] = false;
                    i--;
                }
                i++;
                direction = 4;
                j++;
            }
        }
        return result;
    }
}
