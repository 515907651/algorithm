package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class RemoveDuplicates_26_easy {
    // 不许使用额外空间，原地移动
    // 去重而且记录下标用hashmap
    // 可以不记录下标哎
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        // 记录修改后数组长度，方法是减去删除的数量，也可以直接返回set的大小
        int result = 0;

        HashSet<Integer> set = new HashSet<>();
        // HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                // 当前面有重复的，可以删除后面的，也可以删除前面的，删除后面的应该高效一点。
                for (int j = i; j < n - 1; j++) {
                    // 边界问题，最后一个，i+1越界, 最后一个数移到前面就好了，不用管他
                    // 但是如果后面都完全一样就死循环了，n--；
                    nums[j] = nums[j + 1];
                }
                // 删除了一个，相当于后面的都前移一位，那么这里就要在原地继续判断
                // System.out.println(nums[i+1]);
                n--;
                i--;
            } else {
                set.add(nums[i]);
            }
        }
        return set.size();
    }

    public int removeDuplicates1(int[] nums) {
        // 双指针法，复杂度为n
        // 首先将数组排序，然后从头到尾找不重复的
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        while (j < n) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
