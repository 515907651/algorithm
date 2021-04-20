package offer;

import java.util.ArrayList;
import java.util.List;

public class TwoSum_57_easy {
    // 一点都不easy好么，双指针
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        while (left < right) {
            sum = nums[right] + nums[left];
            if (target == sum) {
                return new int[]{nums[left], nums[right]};
            }
            if (target < sum) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 2;
        List<int[]> lists = new ArrayList<>();
        int sum = 0;
        while (left < right) {
            sum = (right - left + 1) * (left + right) / 2;
            if (sum == target) {
//                List<Integer> temp = new ArrayList<>();
                int[] temp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                lists.add(temp);
                left++;
            } else if (sum < target) {
                right++;
            } else {
                left++;
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }

}
