package offer;

import org.junit.Test;

public class ReversePairs_51_hard {
    // 归并排序的过程中，获取逆序对的个数
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int result = 0;
        result = merge1(nums, 0, nums.length - 1);
        return result;
    }

    private int merge1(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        int count = 0;
        int leftCount = merge1(nums, l , mid);
        int rightCount = merge1(nums, mid + 1 , r);
        int crossCount = merge2(nums, l , mid , r);
        count = leftCount + rightCount + crossCount;
        return count;
    }

    private int merge2(int[] nums, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int m = mid;
        int n = r;
        int count = 0;
        int k = 0;
        int[] temp = new int[nums.length];
        while (i <= m && j <= n) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                k++;
                i++;
            } else {
                temp[k] = nums[j];
                k++;
                j++;
                count += mid - i + 1;
            }
        }
        while (i <= m) {
            temp[k] = nums[i];
            k++;
            i++;
        }
        while (j <= n) {
            temp[k] = nums[j];
            k++;
            j++;
        }
        for (int o = 0; o < k; o++) {
            nums[l + o] = temp[o];
        }
        return count;
    }
    @Test
    public void tempTest() {
        int[] array = new int[]{7,5,6,4};
        System.out.println(reversePairs(array));
    }
}
/*
*
* public class Solution {
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */