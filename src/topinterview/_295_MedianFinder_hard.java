package topinterview;

import java.util.PriorityQueue;

public class _295_MedianFinder_hard {
    // 记得在offer里做过，就是两个堆
    // 一个最小堆和一个最大堆，两个堆的数量保持相等，最多差1
    // 最后取两个堆的堆顶原数的平局值或者多的那一个的值
    // 插入的时候有点小trick
    /** initialize your data structure here. */
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public _295_MedianFinder_hard() {
        // 最大堆存放小于中间数的值
        // 最小堆存放大于中间数的值
        max = new PriorityQueue<>((a,b)->{
            return b - a;
        });
        min = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 首先要保证，最大堆中元素全部小于最小堆
        // 先放到最大堆，也就是左半部分，然后将最大值放入最小堆，也就是右半部分
        max.offer(num);
        min.offer(max.poll());
        if (min.size() > max.size()) {
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        if (max.size() == min.size()) {
            return (double)(max.peek() + min.peek()) / 2;
        } else {
            return (double)max.peek();
        }
    }

}
