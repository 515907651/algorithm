package Arrays;

public class NumMatrix_304_medium {
    // 结合昨天做的那个一维数组，sum[j]-sum[i]+nums[i]
    // 这次是矩阵，是二维的数组，两个sum，一个记录行(sumOR)，一个记录列(sumOC)
    // 不对，一个sum就可以了，把每一行的加起来，这个sum应该是二维的
    // 好蠢，还有个[[[]]]案例，这是人能想出来的？
    // sum的列数可以是column+1，这样就不用讨论column=0的情况了
    // 响应的代码sums[i][j + 1] = sums[i][j] + matrix[i][j];
    // sum += sums[i][col2 + 1] - sums[i][col1];
    // 还可以直接建立二维前缀和sums[i][j]
    // 计算二维前缀和时，f(i,j)=f(i−1,j)+f(i,j−1)−f(i−1,j−1)+matrix[i][j]
    // 计算指定区域的和时，sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    //
    private int[][] sum;
    private int[][] matrix;

    public NumMatrix_304_medium(int[][] matrix) {
        this.matrix = matrix;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int row = matrix.length;
        int column = matrix[0].length;
        sum = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j == 0) sum[i][j] = matrix[i][j];
                else sum[i][j] = sum[i][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int result = 0;
        for (int i = row1; i <= row2; i++) {
            result += sum[i][col2] - sum[i][col1];
        }
        return result;
    }

    // 二维前缀和
    public NumMatrix_304_medium(int[][] matrix, int a) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int row = matrix.length;
        int column = matrix[0].length;
        sum = new int[row + 1][column + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 这一步有点难想
                // 画个图，空出一行一列，相当于将其初始化为0
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion1(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}
