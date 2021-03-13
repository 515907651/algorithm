package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class split {
    //给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
    //
    //如果可以完成上述分割，则返回 true ；否则，返回 false 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static boolean isPossible(int[] nums){
/*
        int n = nums.length;
        if(n<5) return false;
        boolean[] dup = new boolean[n];
        //初始化时是什么？null还是false还是true
        for (int i = 0; i < n-1; i++) {
            if(nums[n]==nums[n+1]) dup[n] = true;
        }
*/
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for(int x : nums){
            if(!map.containsKey(x)){
                map.put(x, new PriorityQueue<Integer>());
            }
            if(map.containsKey(x-1)){
                int prevLength = map.get(x-1).poll();
                if(map.get(x-1).isEmpty()){
                    map.remove(x-1);
                }
                map.get(x).offer(prevLength+1);
            } else {
                map.get(x).offer(1);
            }


        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entries = map.entrySet();
        for(Map.Entry<Integer,PriorityQueue<Integer>> entry:entries){
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) return false;
        }
        return true;
    }

}
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<Integer>());
                //如果x未加入哈希表，将x加入
            }
            if (map.containsKey(x - 1)) {
                //如果哈希表中存在以 x-1结尾的子序列，则取出以 x-1 结尾的最小的子序列长度，
                //将子序列长度加 1 之后作为以 x 结尾的子序列长度
                int prevLength = map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                map.get(x).offer(prevLength + 1);
            } else {
                //新建一个以x为结尾，长度为1的
                map.get(x).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}

