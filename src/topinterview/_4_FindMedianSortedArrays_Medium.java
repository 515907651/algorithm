package topinterview;

public class _4_FindMedianSortedArrays_Medium {
    // 思路很复杂，方法根本想不到，只能想到把两个合并然后再找
    // 大体思路是将两个数组分割成左右两部分，分割后，两数组左右数量相等，且右边的最小值大于左边的最大值，那么中位数就是中间的数了。
    // 要使得左边数量多于或者等于右边，那么中位数就是左边的或者左右的平均数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // 让nums1是长度短一点的
            // return findMedianSortedArrays(nums2, nums1);这个写法太骚了
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        // 分割线左边的数量，这个可太有说法了，我们让左边的数量多或者等于右边的数量，那么和为偶数的时候，+1向下取整，相等，奇数的时候+1就大于右边
        int totalLeft = (m + n + 1) / 2;
        // 初始化二分法边界
        int left = 0;
        int right = m;
        while (left < right) {
            // 先在第一个数组中找到i的位置，这个+1也是有讲究的，英文下面是left = i，不+1就死循环了
            int i = (left + right + 1) / 2;
            // j是第二个数组的分割位置
            int j = totalLeft - i;
            // 这样i和j就实现了左右数量相等，接下来使第一个数组左边的值小于等于第二个数组右边的值
            if (nums1[i - 1] <= nums2[j]) {
                // 右边还有可能有
                left = i;
            } else {
                right = i - 1;
            }
        }
        int i = left;
        int j = totalLeft - left;
        int maxNums1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int minNums1 = i == m ? Integer.MAX_VALUE : nums1[i];
        int maxNums2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int minNums2 = j == n ? Integer.MAX_VALUE : nums2[j];
        if (((m + n)&1) == 1) {
            // 奇数，左边最大值
            return Math.max(maxNums1, maxNums2);
        } else {
            // 偶数，左边最大值和右边最小值的平均
            return (double)(Math.max(maxNums1, maxNums2) + Math.min(minNums1, minNums2)) / 2;
        }
    }
}
