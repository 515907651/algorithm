package offer;

import java.util.PriorityQueue;

public class MedianFinder_41_medium {
    // 找中位数
    // 用一个大顶堆存储小的数，大顶堆堆顶就是最大的
    // 用一个小顶堆存储大的数，小顶堆堆顶就是最小的
    // 把小顶堆放在大顶堆前面就是原始数据了
    // 规定大顶堆数据量<=小顶堆，当总数是奇数时，中位数就是小顶堆的堆顶元素，当总数是偶数时，中位数是两堆顶元素的平均值
    private PriorityQueue<Integer> head;
    private PriorityQueue<Integer> tail;
    public MedianFinder_41_medium() {
        head = new PriorityQueue<Integer>();
        tail = new PriorityQueue<Integer>((x, y) -> (y - x));

    }

    public void addNum(int num) {
        // head的总数必须大于tail的总数
        // 插入的时候，要先放到tail中，再放回head
        // 这个放置过程的核心，就是保证head的元素全部大于tail的元素
        // 对应的，当想放到head里时，要先保证是tail的最大值；想放到tail时，先保证是head的最小值
        if (head.size() == tail.size()) {
            // 偶数，两者元素数量相等，要放到head里
            tail.add(num);
            head.add(tail.poll());
        } else {
            // 奇数，head中多了一个
            head.add(num);
            tail.add(head.poll());
        }
    }

    public double findMedian() {
        double result = 0;
        if (head.size() == 0) {
            return result;
        }
        if (head.size() == tail.size()) {
            return (double) (head.peek() + tail.peek()) / 2;
        } else {
            return (double) head.peek();
        }
    }
}
