package Arrays;

public class FindMin_153_medium {
    // 寻找旋转后的数组的最小值
    // 显然二分法，画个图就明白了，一个单增的曲线中间劈开，高的那一段移动到左边，中间点的选择有两种情况，选在高的那一段
    // 那么中间点值大于右边界值，最小值在右边；选在低的那一段，中间点值小于最高点的值，那么最小值在左边
    // 如果第二种情况，中间点也有可能是最小值
    // 这是找左边界还是右边界呢，左边界，最小值在左边嘛
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }

}
