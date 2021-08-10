package topinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class _380_RandomizedSet_medium {
    // 实现O(1)的insert，delete和random取值
    // 一看就是空间换时间，但是怎么实现想不到，能想到hashmap存取是O(1)，数组实现random取值
    // 但是数组的delete和insert是O(n)
    // 题解给的方法是，利用hashmap存储值和对应的数组索引
    // insert的时候，在数组中加入数字，并且将数字和对应的索引加入map中
    // delete的时候，将目标数字和数组末尾数字交换，然后删除末尾数字，同时更新map中对应的索引
    // 要更新两次，第一次删除数字，第二次更新交换的数字
    // random取值就直接返回数组中的一个索引对应的值就OK
    Map<Integer, Integer> map;
    ArrayList<Integer> array;
    Random random = new Random();
    /** Initialize your data structure here. */
    public _380_RandomizedSet_medium() {
        map = new HashMap<Integer, Integer>();
        array = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.isEmpty() && map.containsKey(val)) {
            return false;
        }
            // 先加入array
            array.add(val);
            // 再加入map
            map.put(val, array.size() - 1);
            return true;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // 删除最麻烦，要记录下删除的和交换的原先的index
        // 一种情况，如果删除的就是最后的值呢，不影响
        if (map.isEmpty() || (!map.isEmpty() && !map.containsKey(val))) {
            return false;
        }
        int[][] temp = new int[2][2];
        // 没必要一个二维数组，只用到了两个值，要删除的值对应的index，最后一个元素的值
        // 要删除的值
        temp[0][0] = val;
        temp[0][1] = map.get(val);
        // 要替换的末尾值
        temp[1][0] = array.get(array.size() - 1);
        temp[1][1] = array.size() - 1;
        // 先将map中的值删除
        map.remove(val);
        // 将array中末尾值换到删除值的位置
        array.set(temp[0][1], temp[1][0]);
        // 删除末尾
        array.remove(array.size() - 1);
        // 将末尾值index改为被删除值的位置
        map.replace(temp[1][0], temp[0][1]);
        return true;
        /*
    int lastElement = list.get(list.size() - 1);
    int idx = dict.get(val);
    list.set(idx, lastElement);
    dict.put(lastElement, idx);
    // delete the last element
    list.remove(list.size() - 1);
    dict.remove(val);
    return true;

作者：LeetCode
链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1/solution/chang-shu-shi-jian-cha-ru-shan-chu-he-huo-qu-sui-j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        * */
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return array.get(random.nextInt(array.size()));
    }

}
