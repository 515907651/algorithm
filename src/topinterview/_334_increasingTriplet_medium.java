package topinterview;

public class _334_increasingTriplet_medium {
    // 背过他
    // 我的思路是从头遍历，每个位置遍历他后面的两个，复杂度n*3
    // 这个思路是不对的，因为三个数字不一定连续，可以是分散的
    // 新的思路，用一个left数组表示当前数字左边有没有小于他的数，right表示右边有没有大于它的数，当左右都有，那么为true，结果时间复杂度和暴力没有区别
    // 题解给的思路，新建两个变量small和mid，当遇到小于s的数，将s变成小的，否则，mid大于这个数，mid变成这个小的，如果大于mid，直接返回true
    public boolean increasingTriplet1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int length = nums.length;
        boolean flag = false;
        for (int i = 0; i <= length - 3; i++) {
            // 保证每个数后面都有两个
            if (nums[i] < nums[i + 1] && nums[i + 1] < nums[i + 2]) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                // 这里要<=，否则不能解决重复问题
                min = nums[i];
            } else if (nums[i] < mid) {
                mid = nums[i];
            } else if (nums[i] > mid){
                return true;
            }
        }
        return false;
    }

}
