package offer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MinNumber_45_medium {
    // 其实大体的思路蛮好想的，类似贪心
    // 让高位取最小值，那么这个最小值的求法就有讲究了，要按位挨个判断数字的大小，但是转成字符串的话比较大小就方便了，字符串就是按位比较大小的
    // 比如"12"和“34”，ASCII值1<3，所以12更小，但是对于位数不同的，如"3"和“30”，没法比较，所以把两者合并成一个字符串再比较大小，比较"303"和"330"，按位比较显然303更小
    // 比较重要的是排序，用个最小堆，每次取最小值
    public String minNumber(int[] nums) {
        StringBuilder result = new StringBuilder();
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            // 返回负数就是小于，整数就是大于
            // sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1))
            public int compare(String o1, String o2) {
                if ((o1+o2).compareTo(o2+o1)>0) {
                    return 1;
                } else if ((o1+o2).compareTo(o2+o1)<0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(String.valueOf(nums[i]));
        }
        System.out.println(queue);
/*
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()){
            result.append(iterator.next());
        }
*/
        // 必须用poll方法才能确保按顺序输出，迭代器只是按加入顺序输出。
        for (int i = 0; i < nums.length; i++) {
            result.append(queue.poll());
        }
        return result.toString();
    }

}
