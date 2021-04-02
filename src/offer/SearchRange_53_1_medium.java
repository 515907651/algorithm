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
        // 扣扣细节
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
                // 当前位置大于等于target，说明起始位置在他的左边或者就是起始位置，所以right不能是mid-1
                // 看题解视频里，把这大于和等于分开了，当大于的时候，right = mid -1;等于的时候，right = mid;其实合并起来变成mid也可以啦，就是多做点无用功
                right = mid;
            } else {
                // 当前数字小于target，说明要找的起始位置在他的右边，所以是mid+1
                left = mid + 1;

            }
        }
        // 最后要判断一下是否有target
        if (nums[left] != target) {
            return result;
        }
        // 此时left == right
        result[0] = left;
        // 这个没整明白为什么不减一了
/*
        right = nums.length;
        // 按照自己思路改的不对啊
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                // 当前位置小于target，那肯定不是末尾，mid+1，当前位置等于target，有可能是末尾，mid
                // 合并的话应该是mid吧
                left = mid + 1;
            } else {
                // 当前位置大于target，那肯定是在末尾后面了，mid-1吧
                right = mid;
            }
        }
        result[1] = left - 1;
*/
        right = nums.length - 1;
        while (left < right) {
            mid = (left + right + 1) >>> 1;
            if (nums[mid] < target) {
                left = mid +1;
            } else if (nums[mid] == target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        result[1] = left;
        return result;
    }
}
