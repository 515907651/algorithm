package topinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_ThreeSum_Medium {
    // 暴力法就是三重循环，但是会出现重复问题，需要去重
    // 第一层优化是将数组排序，每次选择大于等于当前数字的，这样避免了一些重复
    // 但是还是会出现连续两个相等情况，这时需要第二次优化，当相等直接跳过
    // 还有第三层优化，这也太麻烦了
    public List<List<Integer>> threeSum(int[] nums) {
        // 特殊情况判断
        if (nums == null || nums.length < 3) {
            return null;
        }
        // 将数组排序
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return null;
        }
        // 结果
        List<List<Integer>> lists = new ArrayList<>();
        int l = nums.length;
        for (int first = 0; first < l - 2; first++) {
            // 倒数第1和第2都不能取到才对
            // 在第一个之后的a，如果有重复，那么直接跳过就可以了
            if (first !=0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = l - 1;
            int target = -nums[first];
            for (int second = first + 1; second < l - 1; second++) {
                // second不能取最后一个
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    // 和上一个重复，直接跳过
                    continue;
                }
                while (third > second && nums[third] + nums[second] > target) {
                    third--;
                }
                if (third == second) {
                    break;
                }
                if (nums[third] + nums[second] == target) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    lists.add(temp);
                }
            }
        }
        return lists;
    }

}
