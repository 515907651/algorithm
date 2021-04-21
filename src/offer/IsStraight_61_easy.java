package offer;

import java.util.Arrays;

public class IsStraight_61_easy {
    // 我的思路是，先把数组排序，找出不连续的数量n，然后看n是否小于0的个数
    // 还要考虑重复的情况
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) {
            return false;
        }
        // 不连续的数目，也就是需要0的数量
        int n = 0;
        // 0的数量
        int zero = 0;
        Arrays.sort(nums);
        int i = 0;
        while (nums[i] == 0) {
            i++;
            zero++;
        }
        // 找不连续的数量
        int temp = 0;
        for (int j = i; j < nums.length - 1; j++) {
            temp = nums[j + 1] - nums[j];
            if (temp >= 2) {
                n += temp - 1;
            }
            // 如果除0外的其他数字重复，肯定不是顺子
            if (temp == 0) {
                return false;
            }
        }
        if (n <= zero) {
            return true;
        }
        return false;
    }

}
