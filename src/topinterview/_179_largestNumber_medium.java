package topinterview;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _179_largestNumber_medium {
    // 之前写过，利用字符串判断大小，最大堆
    // 判断特殊情况，多个0的时候，只要首位为0，直接返回0就ok
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1 + o2).compareTo(o2 + o1);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(Integer.toString(nums[i]));
        }
        StringBuffer ans = new StringBuffer();
        while (!queue.isEmpty()) {
            ans.append(queue.poll());
        }
        if (ans.charAt(0) == '0') {
            return "0";
        }
        return ans.toString();
    }

}
