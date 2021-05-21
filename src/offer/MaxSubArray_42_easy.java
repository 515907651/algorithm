package offer;

public class MaxSubArray_42_easy {
    // 就一简单的动态规划
    // 状态是sum，改变状态的变化是以i为结尾，sum[i]代表以i为结尾的连输数组的最大值
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        if (nums.length == 1) {
            return sum[0];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] > nums[i] + sum[i - 1] ? nums[i] :  nums[i] + sum[i - 1];
            if (sum[i] > max) {
                max = sum[i];
            }
        }
        return max;
    }

}
