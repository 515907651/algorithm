package topinterview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class _128_longestConsecutive_medium {
    // 找连续数列，不考虑顺序
    // 我的思路是，先排序，对于每一个数字，看他有多少个++，取最大值
    // 这个思路的问题可以继续优化
    // 如果有x，x+1...，x遍历过了，就没必要再去遍历x+1，怎么解决呢，就是看当前位置cur，数组中是否存在cur-1，如果存在，跳过
    // 判断存在就直接用set
    // 用了set就不需要排序了，首先将所有元素加入set，然后依次遍历，如果存在cur-1就跳过，不存在就看他有多少个++，记录下最大值

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int temp : nums) {
            set.add(temp);
        }
        int max = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int temp = iterator.next();
            int current = 0;
            if (!set.contains(temp - 1)) {
                while (set.contains(temp)) {
                    temp++;
                    current++;
                }
                max = Math.max(max, current);
            }
        }
        return max;
    }

}
