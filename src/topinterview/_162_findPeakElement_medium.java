package topinterview;

public class _162_findPeakElement_medium {
    // 简简单单二分查找，看到log就想到了
    // 大体思路是找局部峰值，对于mid，当他小于右边临近元素时，说明他处于一个升序，那么峰值在他的右边，不包括他
    // 大于时，峰值在左边，包括他本身
    // 虽然一遍过了，但是不懂为什么mid+1不会越界。嗷，如果mid=n-1的话，left=right=n-1，跳出循环了

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int left = 0;
        // 这个地方取n还是n-1呢
        int right = n - 1;
        while (left < right) {
            // 最后跳出的时候，l=right，也就是峰值
            // 会不会mid=n-1，然后没有右边的元素比较？，应该不会吧
            //
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                // mid+1会越界吧
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
