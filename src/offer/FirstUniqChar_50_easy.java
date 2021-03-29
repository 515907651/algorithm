package offer;

import java.util.*;

public class FirstUniqChar_50_easy {
    // 自己的思路
    // 建一个哈希set，把所有字符往里加，啊，问题是要找第一个啊
    // 那先把所有重复的剔除了，找不重复的第一个，好垃圾的思路
    // 那建一个hashmap，把所有字符往里加，附带当前位置，然后遍历找出位置最小的。
    public char firstUniqChar(String s) {
        // hashmap最大容量是2的30次幂
        Map<Character, Integer> map = new HashMap<>(50000);
        char result = ' ';
        if (s == null || s.length() == 0) {
            return result;
        }
        int n = s.length();
        // 将字符加入map
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp) && map.get(temp) != Integer.MAX_VALUE) {
                map.remove(temp);
                map.put(temp,Integer.MAX_VALUE);
            }
            if (!map.containsKey(temp)){
                map.put(temp,i);
            }
        }
        // 遍历map
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        int min = Integer.MAX_VALUE;
        while (iterator.hasNext()){
            int temp = iterator.next().getValue();
            if (temp != Integer.MAX_VALUE && temp < min){
                min = temp;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return result;
        }
        result = s.charAt(min);
        return result;
    }
    // 长也是一种苦恼啊
    // 题解给的方法是记录频数
    public char firstUniqChar1(String s) {
        char result = ' ';
        if (s == null || s.length() == 0) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // 这么写不优雅
/*
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) +1);
            }
*/
            char temp = s.charAt(i);
            map.put(temp, map.getOrDefault(temp,0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return result;
    }

}
