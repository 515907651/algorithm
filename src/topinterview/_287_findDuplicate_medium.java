package topinterview;

import java.util.Arrays;

public class _287_findDuplicate_medium {
    // 求出等差数列前n项和，再用数组和减去它
    // 这个重复数字可以有多个，比如2,2,2,2,2
    public int findDuplicate(int[] nums) {
        // 不通过，只有一般情况，比如除了一次重复外，其他都是等差数列
        int n = nums.length;
        if (n == 2) {
            return 1;
        }
        int sum1 = (1 + n - 1) * (n - 1) / 2;
        for (int i = 0; i < n; i++) {
            sum1 -= nums[i];
        }
        return -sum1;
    }

    public int findDuplicate1(int[] nums) {
        // 先排序，再判断
        // 这样就破坏了数组原有的结构，题目要求不能改变原数组
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public int findDuplicate2(int[] nums) {
        // 快慢指针
        // 注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
        // 因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
        // 找环入口的方法：快指针走两步，慢指针走一步，相遇后，慢指针归零，快慢指针同时走相同步数，相遇时即为入口
        int fast = 0;
        int slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        slow = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    public int findDuplicate3(int[] nums) {
        // 另一种写法
        int fast = 0;
        int slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                slow = 0;
                while (fast != slow) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return fast;
            }
        }
    }

    }
