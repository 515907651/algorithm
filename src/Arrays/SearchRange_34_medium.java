package Arrays;

public class SearchRange_34_medium {
    // 之前做过一次，但是云里雾里的，现在再回头来看，这思路就很清晰了
    // 找他出现的范围，就是找个左边界，再找个右边界
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = -1;
        int rightIndex = -1;
        if (nums == null || nums.length == 0) {
            return new int[]{leftIndex, rightIndex};
        }
        // 先找左边界，也就是第一次出现的位置
        int left = 0;
        int right = nums.length;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        leftIndex = left;
        if (left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        right = nums.length;
        // 找右边界
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        rightIndex = right - 1;
        if (leftIndex <= rightIndex) {
            return new int[]{leftIndex, rightIndex};
        } else {
            return new int[]{-1, -1};
        }
    }
}
