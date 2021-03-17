package offer;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_39_easy {
    public int majorityElement(int[] nums) {
        // 要求空间复杂度为1，时间复杂度为n
        // 也就是遍历一次
        // 首先想到的方法是建立一个hashmap记录每个元素出现的次数
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        Map.Entry<Integer,Integer> entry = null;
        for (Map.Entry<Integer,Integer> temp : map.entrySet()) {
            if (entry == null || entry.getValue() < temp.getValue()){
                entry = temp;
            }
        }
        return entry.getKey();
    }

}
