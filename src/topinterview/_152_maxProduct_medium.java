package topinterview;

public class _152_maxProduct_medium {
    // 看到题，就有思路，虽然是错误的，哈哈哈哈
    // 我的思路是建立一个dp[i]代表以i为结尾的最大连续乘积，那么i+1就是他本身或者乘上dp[i]
    // 但是这样没有考虑到正负值，如果当前位置是一个正的，那么我们希望他乘上一个尽可能大的数，如果是一个负的，希望他乘上一个尽可能小的
    // 所以再建立一个dp[i]代表以i为结尾的最小连续乘积
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        // 初始化
        max[0] = nums[0];
        min[0] = nums[0];
        // 没判断0位置
        int ans = Math.max(Integer.MIN_VALUE, nums[0]);
        for (int i = 1; i < n; i++) {
            // 对于i的正负分类讨论，0怎么办？
            if (nums[i] >= 0) {
                max[i] = Math.max(nums[i], nums[i] * max[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * min[i - 1]);
            } else {
                max[i] = Math.max(nums[i], nums[i] * min[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * max[i - 1]);
            }
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }

}
