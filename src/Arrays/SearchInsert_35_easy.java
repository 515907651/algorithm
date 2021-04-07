package Arrays;

public class SearchInsert_35_easy {
    public int searchInsert(int[] nums, int target) {
        // 查找简单，插入怎么做呢
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 这里结果是left == right，所以返回left和right是一样的
        return left + 1;
        // 这个left就代表着数组中小于target的数量
    }

}
