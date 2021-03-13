package DP;

import java.util.Arrays;

public class LengthOfLIS_300_medium {
    public int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
    public int lengthOfLIS1(int[] nums) {
        // 题解
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;//为什么初始化是1
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;//为什么初始化是1
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    public int lengthOfLIS2(int[] nums) {
        // 题解，贪心+dp
        // dp[i]代表长度为i的子序列的最后一个数的最小值
        // 否则，在数组中二分查找，找到第一个比 nums[i] 小的数 d[k] ，并更新 d[k+1]=nums[i]
        // 这句话理解不了
        // 对于dp[k]<nums[i]<dp[k+1],那么就把dp[k+1]替换为nums[i],因为dp[i]的定义
        if (nums==null||nums.length==0) return 0;
        int[] dp = new int[nums.length+1];
        int length = 1;
        dp[1] = nums[0];// 要注意length是从1开始的
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>dp[length]) {
                dp[++length] = nums[i];
            }
            else if (nums[i]<dp[length]){
                boolean flag = true;
                for (int j = length-1; j > 0; j--) {
                    if (nums[i]>dp[j]){
                        dp[j+1] = nums[i];
                        flag = false;
                        break;
                    }
                }
                if (flag) dp[1] = nums[i];
            }
        }
        return length;
    }
    public int lengthOfLIS3(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }




}
