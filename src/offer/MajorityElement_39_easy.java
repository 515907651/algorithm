package offer;

import java.util.Arrays;
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
    public int majorityElement1(int[] nums) {
        // 遍历数组的时候就确定最大值，不进行最后那一次遍历
        // 要考虑到只有一个元素的数组，这个时候没有重复
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxNum = 0;
        int count = 0;
        int temp;
        if (nums.length <= 2) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                temp = map.get(nums[i]);
                if (count < temp) {
                    count = temp;
                    maxNum = nums[i];
                }
                map.put(nums[i], temp + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return maxNum;

    }
    public int majorityElement2(int[] nums) {
        // 直接排序，排序后中间那个数肯定是众数
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public int majorityElement3(int[] nums) {
        // 投票法
        if (nums.length <= 2) {
            return nums[0];
        }
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    temp = nums[i];
                    count = 1;
                }
            }
        }
        return temp;
    }

    }
