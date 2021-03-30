package Arrays;

public class SearchMatrix_74_medium {
    // 有点像二分查找，不过是在二维矩阵上进行的
    // 难点就是怎么把二维坐标转换为一维坐标
    // 取余和除法运算
    // 淦，把row当成了本行的列数
    public boolean searchMatrix(int[][] matrix, int target) {
        // 还要考虑一些特殊情况的
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        // int right = row * column;
        int right = row * column - 1;
        int mid = 0;
        int left = 0;
        int i = 0;
        int j = 0;
        while (left <= right) {
            // 先将一维坐标转换为二维坐标
            mid = (left + right) / 2;
            i = mid/column;
            j = mid%column;
            if (matrix[i][j] > target) {
                right = mid - 1;
            } else if (matrix[i][j] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
