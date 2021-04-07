public class Binary {
    public int binaryFind(int[] nums, int target) {

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
        return -1;
    }
    public int binaryFind1(int[] nums, int target) {

        int left = 0;
        int right = nums.length;
        while (left < right) {
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


    public int binaryFindLeft(int[] nums, int target) {
        // 左边界版本的二分查找
        // 比如1,2,2,2,3，找2
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        // 还有个nums.length - 1 版本的
        int right = nums.length;
        while (left < right) {
            // 这里的区间是[left, right)，因为right是nums.length，数组越界，取不到
            // 当结束时，left == right，所以区间是[left, left)，搜索完了
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 相等时，mid左面可能还有target
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 这里应该是right = mid，因为right是右边界，不包括的，而不是mid - 1；
                right = mid;
            }
        }
        if (left == nums.length) {
            return 0;
        }
        return nums[left] == target ? left : -1;

/*
        // labuladong的代码
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
*/
    }
    public int binaryFindLeft1(int[] nums, int target) {
        // length - 1版本的
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        // 还有个nums.length - 1 版本的
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 这里是mid - 1，而不是mid
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }
    public int binaryFindRight1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        // 还有个nums.length - 1 版本的
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 返回值应该是left - 1，因为上面left = mid + 1，也就是mid = left - 1；
        if (left == 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }
    public int binaryFindRight2(int[] nums, int target) {
        // length - 1版本的
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 返回值为什么是right，结束时区间是[right, left]，右边界应该是left啊
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

}
