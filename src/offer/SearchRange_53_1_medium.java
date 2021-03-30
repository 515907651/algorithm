package offer;

public class SearchRange_53_1_medium {
    // 自己的思路就是挨个去找，然后找到了就加入结果数组
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                int j = i + 1;
                while (j < nums.length){
                    if (nums[j] != target) {
                        break;
                    }
                    j++;
                }
                // 还要判断是否是因为到达终点，没必要
                result[1] = j - 1;
                break;
            }
        }
        return result;
    }

    public int[] searchRangeBi(int[] nums, int target) {
        // 题解方法是二分法，时间复杂度logn
        // 先找leftIndex，也就是第一个大于等于target的，再找RightIndex，也就是第一个大于target的
        // 最后判断两个Index是否合理，然后决定是返回-1，-1还是正常值
        int[] result = new int[]{-1,-1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left < right){
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            return result;
        }
        result[0] = left;
        right = nums.length - 1;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        result[1] = left - 1;
        return result;
    }
}
