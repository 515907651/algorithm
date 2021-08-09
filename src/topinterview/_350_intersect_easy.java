package topinterview;

import java.util.*;

public class _350_intersect_easy {
    // 暴力法确实是easy，暴力法也不简单好吧
    // 对于nums1的每个数，去找nums2对应的数，但是重复的怎么解决？加标记
    // 用hashmap来做，先把短的数组加入hashmap，然后遍历长数组
    // 当相同时，hashmap中对应的值--，并加入list，当值变为0的时候，不在加入，这是简单的，能够优化，变成0直接删除，但是要判断hashmap是否为空
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        // 不用选最短的加入，都是要遍历的
        Map<Integer, Integer> map = new HashMap<>(l1 + l2);
        for (int i = 0; i < l1; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i],0) + 1);
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < l2; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        // 排序好的两个数组
        // 双指针，p1和p2指向两数组头部，比较大小，小的后移
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        List<Integer> list = new LinkedList<>();
        while (p1 < l1 && p2 < l2) {
            if (nums1[p1] == nums2[p2]) {
                list.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

}
