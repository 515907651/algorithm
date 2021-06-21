package topinterview;

public class _55_CanJump_Medium {
    // 题解思路就是维护一个最远距离，当最远距离大于等于最大长度时，可以到达
    // 对于当前位置x，他的最远距离是x + nums[x]
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max >= i) {
                // 要保证i这个位置在最大能到达位置内
                max = Math.max(max, i + nums[i]);
                if (max >= n - 1) {
                    return true;
                }
            }

        }
        return false;
    }
}
