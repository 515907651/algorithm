package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup_90_medium {
    // 这题主要问题还是重复的问题，如果允许重复的话，就很好做了
    // 看了题解，发现每次把之前所有的子集复制出来，加上当前的数字组成新子集，再放回去
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先允许重复做一下看看
        // 这个就是78题
        List<Integer> init = new LinkedList<>();
        result.add(init);
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            // 遍历所有数字
            int size = result.size();
            for (int j = 0; j < size; j++) {
                // 复制所有的子集
                List<Integer> temp = new LinkedList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        // 回溯法
        // 思路就是去找长度为0-k的子集
        // 不会写，接近于抄题解了
        for (int i = 0; i <= nums.length; i++) {
            // 找出所有长度
            recur(0, i, nums, new LinkedList<>());
        }
        return result;
    }

    private void recur(int start, int length, int[] nums, List<Integer> list) {
        if (length == 0) {
            result.add(new LinkedList<Integer>(list));
            return;
        }
        for (int i = start; i < length; i++) {
            list.add(nums[i]);
            recur(i + 1, length - 1, nums, list);
            list.remove(list.size() - 1);
        }

    }
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        // 去重版本的找子序列
        // 基本思想是，每次加入新的子序列都是当前数字和前面所有的子序列结合，也就是数量翻番，设开始的数量是m
        // 如果有重复的，比如这一轮生成的子序列是2m，那么重复的那些是这2m里的前m个
        // 举个栗子 1,2,2
        // 一开始是空的，只有一个空子串；然后对于1，生成了个1，现在有两个；对于第一个2，生成了2和1,2，现在有四个；对于第二个2，如果和前两个结合，就重复了，和后两个结合不会，也就是生成两个。
        List<Integer> temp = new ArrayList<>();
        int length = 0;
        result.add(new ArrayList<>());
        // 每次都要新建一个，不然之前加入了temp，再加入改变的temp的时候，会覆盖掉。不要怕内存消耗
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        temp.add(nums[0]);
        result.add(temp);
        if (nums.length == 1) {
            return result;
        }
        length = 1;
        int n = 0;
        for (int i = 1; i < nums.length; i++) {
            n = result.size();
            if (nums[i] != nums[i - 1]) {
                // 没有重复，那么就让所有的子集和当前数字结合，也就是和2m个子序列结合
                // 有重复的话，length就应该等于上次结合前的子序列数，也就是和m个子序列结合
                length = n;
            }
            for (int j = n - length; j < n; j++) {
                List<Integer> temp1 = new ArrayList<>(result.get(j));
                temp1.add(nums[i]);
                result.add(temp1);
            }
        }
        return result;

    }


}
