package topinterview;

public class _240_searchMatrix_medium {
    // 简简单单二分查找，并不是，一个找规律的
    // 左下角元素是一列中最大的，也是一行中最小的
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int beginR = row - 1;
        int beginC = 0;
        while (beginR >= 0 && beginC < column) {
            if (matrix[beginR][beginC] == target) {
                return true;
            }
            if (matrix[beginR][beginC] < target) {
                beginC++;
            }else if (matrix[beginR][beginC] > target) {
                beginR--;
            }
        }
        return false;
    }

}
