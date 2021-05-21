package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxSlidingWindow_59_1_hard {
    // 滑动窗口中的最大值
    //
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 先建立一个优先队列，存放k个值和对应的index
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) ->{
            return a[0] - b[0];
        });
        // 将k个数组放入queue
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        // 结果的长度，其中存放最大值
        int[] ans = new int[nums.length - k + 1];
        ans[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            // 每次放入的时候都要判断堆顶元素是否在窗口中，不在就移除
            queue.offer(new int[]{nums[i],i});
            while (queue.peek()[1] < i - k +1) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        // 方法1的进阶版本
        // 维护一个双端队列，队列中存放index，保证队列中index对应的数字单调递减，当加入的值大于队尾值时，移除队尾直至可以加入
        // 当队首元素值不在滑动窗口中时，移除队首
        if (nums == null || nums.length < 2) {
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 移除队尾
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 移除队首
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 添加结果，这里判断一下是否已经构成了窗口
            if (i + 1 > k) {
                ans[i - k] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }


}
