package Arrays;

public class Search_81_medium {
    // 有重复数字的旋转有序数组
    // 依旧是二分查找，当遇到mid和两边相等时，mid-1；
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left +(right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[mid] >= nums[left]) {
                // 左边有序
                if (nums[mid] > target && nums[left] <= target) {
                    // 在左边有序数组里
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) {
                // 这里这个条件有点迷，之前是<，通不过
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

}
