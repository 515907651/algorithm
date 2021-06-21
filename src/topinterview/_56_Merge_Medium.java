package topinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_Merge_Medium {
    // 题解思路是，将数组先按第一个数的大小排序
    // 妈的，好难
    // 维护一个数组链表，先将第一个数组加入，然后依次判断之后的
    // 如果当前数组左端点在末尾的右边，那么两个数组不重合
    // 否则更新右边端点为最大的那个
    // 理解了！第一次排序使得后面的左端点都递增，假设list最后的数组为a，当前数组为b
    // 那么有a[0] <= b[0]，如果出现a[1] > b[0]的情况，说明有重叠，重叠区域的左端点就是最小的a[0]，右端点是a[1]和b[1]中最大的，建议画个图
    // 如果出现a[1] < b[0]，那么说明不重叠，直接加入就OK
    public int[][] merge(int[][] intervals) {
        // 特殊情况判断
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][2];
        }
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b)->{
            return a[0] - b[0];
        });
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = result.get(result.size() - 1);
            if (result.isEmpty() || temp[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                result.get(result.size() - 1)[1] = Math.max(temp[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
