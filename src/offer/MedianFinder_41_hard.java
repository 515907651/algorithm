package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder_41_hard {
    private PriorityQueue<Integer> queueMax;
    private PriorityQueue<Integer> queueMin;
    private int count;

    public MedianFinder_41_hard() {
        queueMax = new PriorityQueue<>(new Comparator<Integer>() {
            // 最大堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queueMin = new PriorityQueue<>(new Comparator<Integer>() {
            // 最小堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        count = 0;

    }


    public void addNum(int num) {
        // 用判断奇偶来添加是不对的
        // 要保证max中的数字全部小于min，应该先入max，然后max把最大值给min，当count为奇数时，min给max最小值
        count++;
/*
        if ((count & 1) == 1){
            // count是奇数，要放到最大堆里
            queueMax.offer(num);
        } else {
            queueMin.offer(num);
        }
*/
        queueMax.offer(num);
        queueMin.offer(queueMax.poll());
        if ((count & 1) == 1) {
            queueMax.offer(queueMin.poll());
        }

    }

    public double findMedian() {
        if ((count & 1) == 1){
            // 奇数，返回一个值就ok
            return (double)queueMax.peek();
        } else {
            // 偶数，返回两值的平局值
            return (double)(queueMax.peek() + queueMin.peek())/2;
        }
    }

}
