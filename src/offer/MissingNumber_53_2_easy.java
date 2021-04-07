package offer;

public class MissingNumber_53_2_easy {
    // 找个数字，最简单的，直接找
    // 如果当前数字不等于n-1，那么它就不正常
    // 当排序数组中缺失某一位后，后面的肯定大于当前索引
    public int missingNumber(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid) {
                // 说明最后一个正常的在左面
                //
                right = mid -1;
            } else {
                // 不可能小于当前索引
                // 当前索引等于当前值
                left = mid + 1;
            }
        }
        // 最后left==right，此时当前位置就是
        return left;
    }

}
