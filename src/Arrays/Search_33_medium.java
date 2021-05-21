package Arrays;

public class Search_33_medium {
    // 我想用递归+二分法来做
    // 好像不递归也可以，试试，不行啊，只能递归了
    // 其实直接排序然后二分查找也OK了

    public int search2(int[] nums, int target){
        // 非递归
        // 一分为二，去找有序的那一段，判断target是否在其中，在就搜索他，不在就去无序的那一边重复此过程
        // 出了问题，在nums[mid] >= nums[left]这里，mid是向下取值的，有可能取到left。但是right是取不到的7
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                // 左边有序
                if (nums[mid] > target && nums[left] <= target) {
                    // 在左边有序数组里
                    right = mid - 1;
                } else {
                    // 去右边无序数组里找
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) {
                // 右边有序
                if (nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    // 去左边无序数组里找
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        return search1(nums, left, right, target);
    }
    public int search1(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > nums[left]) {
            // 左边有序，对左边进行二分查找
            // 那么右边就重复此操作
            int result = binaryFind(nums, left, mid - 1, target);
            if (result != -1) {
                return result;
            }
            search1(nums, mid + 1, right, target);
        } else if (nums[mid] < nums[right]) {
            // 右边有序，对右边进行二分查找
            // 左边重复此操作
            int result = binaryFind(nums, mid + 1, right, target);
            if (result != -1) {
                return result;
            }
            search1(nums, left, mid - 1, target);

        }
        return -1;
    }
    public int binaryFind(int[] nums, int left, int right, int target) {

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
        return -1;
    }

}
