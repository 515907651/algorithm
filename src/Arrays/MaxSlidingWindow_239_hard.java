package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值

* */
public class MaxSlidingWindow_239_hard {
    public static void main(String[] args) {

    }
    private static int[] maxSlidingWindow(int[] nums, int k){
        if (k==0||nums==null) return null;
        int l = nums.length;
        int[] result = new int[l-k+1];
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i],i});
        }
        result[0] = queue.peek()[0];
        for (int i = k; i < l; i++) {
            queue.offer(new int[]{nums[i],i});
            while (queue.peek()[1]<=i-k){
                queue.poll();
            }
            result[i-k+1] = queue.peek()[0];
        }

        return result;
    }
}
