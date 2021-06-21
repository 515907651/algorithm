package topinterview;

public class _41_FirstMissingPositive_hard {
    // 代码很好写，思路特别难想
    // 对于一个数组缺失的最小值
    // 如果数组中不存在1，那么最小值是1
    // 如果存在1，那么将所有的数字转成正数，负数变成数组长度n加一
    // 然后遍历数组，对于小于n的数字，将他的值对应的下标数字变为负数，注意，先取绝对值再变负数，因为之前可能已经变过了
    // 遍历完之后，所有出现的数字对应的下标都是负的，找到第一个正数，他的下标+1就是结果
    // 如果没有正数，那么n+1就是结果
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 将0和负数变为正数
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            // 将对应位置变成负数
            int num = Math.abs(nums[i]);
            if (num <= n) {
                // 防止之前的就是负数
                // 这个地方不好理解，将对应位置的值变成负数
                // 对应位置是num - 1
                nums[num - 1] = - Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
