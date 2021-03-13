package Arrays;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class NextGreaterElement_496_easy {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 理解错了，正确的理解应该是先找到在nums1中出现的数，然后去nums2中找到其对应的位置，再往后找大数
        // 注意结尾
        if (nums1==null||nums2==null) return null;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] result = new int[n1];
        if (n1==0) return result;
        Arrays.fill(result,-1);
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i]==nums2[j]){
                    if (j==n2-1) break;
                    for (int k = j+1; k < n2; k++) {
                        if (nums1[i]<nums2[k]){
                            result[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return result;
    }
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        if (nums1==null||nums2==null) return null;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] result = new int[n1];
        if (n1==0) return result;
        Deque<Integer> stack = new LinkedList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            // push的时机
                while (!stack.isEmpty()&&stack.peek()<nums2[i]){
                    hashMap.put(stack.pop(),nums2[i]);
                }

            stack.push(nums2[i]);

        }
        while (!stack.isEmpty()){
            hashMap.put(stack.pop(),-1);
        }
        for (int i = 0; i < n1; i++) {
            result[i] = hashMap.get(nums1[i]);
        }
        return result;
    }

}
