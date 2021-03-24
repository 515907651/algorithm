package Arrays;

import java.util.TreeMap;

public class Find132pattern_456_medium {
    // 132模式就是ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj
    // 怎么找呢，遍历一遍，每次三个数，确定这三个符合132模式
    // 注意读题，i,j,k可以是不相邻的
    // 先来个n^2方法以示敬意
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int n = nums.length;
        int min = nums[0];
        for (int i = 1; i < n-1; i++) {
            if (min >= nums[i]) {
                min = nums[i];
                continue;
            } else {
                for (int j = i+1; j < n; j++) {
                    if (nums[j] < nums[i] && nums[j] > min) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean find132pattern1(int[] nums) {
        // 改造一下，看看能不能时间复杂度o(n)
        if (nums.length < 3) {
            return false;
        }
        int n = nums.length;
        int min = nums[0];
        // 利用TreeMap存放右侧的值
        TreeMap<Integer,Integer> right = new TreeMap<>();
        for (int i = 2; i < n; i++) {
            // 把nums和对应的索引存放进map里，不知道题解写的那种方式
            right.put(nums[i], right.getOrDefault(nums[i],0) + 1);
/*
            // 这句话什么意思啊
            // 难道是考虑到num有重复？
            // 应该是考虑到重复的问题，treemap不能有重复的key值
            right.put(nums[i], right.getOrDefault(nums[i],0)+1);
*/
        }
        for (int i = 1; i < n-1; i++) {
            if (min < nums[i]) {
                Integer next = right.higherKey(min);
                if (next != null && next < nums[i]) {
                    return true;
                }
            }
            min = Math.min(min, nums[i]);
            // 这里要考虑重复了
            if (right.getOrDefault(nums[i+1],0) == 1) {
                right.remove(nums[i+1]);
            } else {
                right.put(nums[i+1], right.get(nums[i+1])-1);
            }
        }

        return false;
    }
}
