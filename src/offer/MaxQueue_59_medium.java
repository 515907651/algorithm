package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue_59_medium {
    // 实现一个可以求最大值的队列，我想用list来着，先用数组实现一下,list无法实现记录头尾位置吧
    private int[] array;
    private int left;
    private int right;

    public MaxQueue_59_medium() {
        array = new int[2000];
        left = 0;
        right = 0;
    }

    public int max_value() {
        if (left == right) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = max > array[i] ? max : array[i];
        }
        return max;
    }

    public void push_back(int value) {
        array[right++] = value;
    }

    public int pop_front() {
        if (left == right) {
            return -1;
        }
        return array[left++];
    }

    // 用两个队列实现，平均O(1)
    // deque用来存储最大值，当插入的值大于前面的值时，前面的值无论如何都不是最大值，可以移除，当删除的值是最大值时，最大值变成deque后面的一个
    Deque<Integer> deque;
    // queue用来存放加入的值
    Queue<Integer> queue;

    public MaxQueue_59_medium(int temp) {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value(int temp) {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value, int temp) {
        if (!deque.isEmpty() && value > deque.peekLast()) {
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }

    public int pop_front(int temp) {
        if (queue.isEmpty()) {
            return -1;
        }
        int ans = queue.poll();
        if (ans == deque.peekFirst()) {
            deque.pollFirst();
        }
        return ans;
    }

}
