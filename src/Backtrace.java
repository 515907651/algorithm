import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Backtrace {
    // 回溯算法专题
    // 通用模板
/*
    result = []
    def backtrack(路径, 选择列表):
        if 满足结束条件:
            result.add(路径)
            return
        for 选择 in 选择列表:
            做选择
            backtrack(路径, 选择列表)
            撤销选择
*/
    // 首先是找所有子集、
    public List<List<Integer>> subsets(int[] nums) {
        // 因为是所有子集，化成多叉树就是所有的节点，而不是一般的叶子节点，所以应该将结果都加入result
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // 特殊情况判断
        if (nums == null || nums.length == 0) {
            return result;
        }
        backtrace(result, list, nums, 0);
        return result;
    }

    private void backtrace(List<List<Integer>> result, List<Integer> list, int[] nums, int n) {
/*
        if (n == nums.length) {
            // 结束条件，当遍历完数组
            result.add(new ArrayList<>(list));
            return;
        }
*/
        result.add(new ArrayList<>(list));
        // 这里一定要用new ArrayList<>(list)，而不是list，再去找找为什么
        for (int i = n; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }

    }

    @Test
    public void subsetsTest() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        for (List temp : subsets) {
            System.out.println(temp.toString());
        }
    }

    /**
     * 数字组合.
     * 不能重复
     * */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // 特殊情况判断
        if (k <= 0 || n <=0) {
            return result;
        }
        backtrace1(n, k, result, list, 0, 1);
        return result;
    }

    /**
     * 回溯法解决数字组合.
     * @param i 当前的位置
     * */
    private void backtrace1(int n, int k, List<List<Integer>> result, List<Integer> list, int i, int j) {
        if (i == 2) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int l = j; l <= n; l++) {
            list.add(l);
            backtrace1(n, k, result, list, i + 1, l + 1);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void combineTest() {
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = combine(n, k);
        for (List temp : combine) {
            System.out.println(temp.toString());
        }
    }

    /**
     * 数字排列
     * */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        backtrace2(result, nums, list);
        return result;
    }

    /**
     * 排列回溯.
     * 当有重复的时候直接跳过.
     * */
    private void backtrace2(List<List<Integer>> result, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (list.contains(nums[j])) {
                continue;
            }
            list.add(nums[j]);
            backtrace2(result, nums, list);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void permuteTest() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        for (List temp : result) {
            System.out.println(temp.toString());
        }
    }
}
