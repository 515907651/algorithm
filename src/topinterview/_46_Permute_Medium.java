package topinterview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _46_Permute_Medium {
    // 简简单单的回溯，之前做过，一定要一次AC
    public List<List<Integer>> permute(int[] nums) {
        // 特殊条件判断
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        recur(result, temp, nums);
        return result;
    }

    private void recur(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (temp.contains(nums[j])) {
                continue;
            }
            temp.add(nums[j]);
            recur(result,temp,nums);
            temp.remove(temp.size() - 1);
        }
    }
    @Test
    public void tempTest(){
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        result = permute(nums);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
