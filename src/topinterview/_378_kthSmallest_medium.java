package topinterview;

public class _378_kthSmallest_medium {
    public int kthSmallest(int[][] matrix, int k) {
        // 先把最优解二分查找写一遍，再写一遍归并排序，复习一下
        // 特殊情况判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[row - 1][column - 1];
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (check(matrix, mid, k)) {
                // check的逻辑，check求的是有多少数小于等于mid，最后判断数量和k的大小，数量大，说明应该缩小mid的取值
                // 当数量大于等于k，说明答案不大于mid
                // 但是为什么是mid不是mid+1
                r = mid;
            } else {
                // 数量小，说明应该扩大mid的取值
                // 数量少于k，说明答案大于mid
                l = mid + 1;
            }
        }
        // 最后的值为什么正好等于l或者r呢
        return l;
    }

    private boolean check(int[][] matrix, int mid, int k) {
        // 对格子从左下角开始遍历
        // 当值小于等于mid的时候，向右运动，并且数量num等于当前的i+1
        // 当值大于mid的时候，向上运动
        // 直到走出格子
        int row = matrix.length;
        int column = matrix[0].length;
        int num = 0;
        int i = row - 1;
        int j = 0;
        while (i < row && i >= 0 && j < column && j >= 0) {
            // 当没有出格子
            if (matrix[i][j] > mid) {
                i--;
            } else {
                num += i + 1;
                j++;
            }
        }
        return num >= k;

    }


}
