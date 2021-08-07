package topinterview;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347_topKFrequent_medium {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b)->{
            return a[1] - b[1];
        });
        for (int i = 0; i < nums.length; i++) {
            // 加入的步骤又忘了
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (heap.size() < k) {
                heap.offer(new int[]{key,value});
            } else {
                if (heap.peek()[1] < value) {
                    heap.poll();
                    heap.offer(new int[]{key, value});
                }
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll()[0];
        }
        return ans;
    }

}
