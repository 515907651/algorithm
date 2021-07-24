package topinterview;

public class _215_findKthLargest_medium {
    // 之前写过我记得，就是只找半边的快排，快排都快忘了
    public int findKthLargest(int[] nums, int k) {
        // 首先是各种特殊情况判断
        if (nums == null || nums.length == 0 || k < 0) {
            return -1;
        }
        return quickSort(nums, k, 0, nums.length - 1);
    }

    private int quickSort(int[] nums, int k, int l, int r) {
        if (l <= r) {
            int init = partition(nums, l, r);
            if (init == nums.length - k) {
                return nums[init];
            } else {
                return init > nums.length - k ? quickSort(nums, k, l, init - 1) : quickSort(nums, k, init + 1, r);
            }
        }
        return -1;
    }

    private int partition(int[] nums, int l, int r) {
        // 这里记得滚瓜烂熟
        if (l >= r) {
            return l;
        }
        int temp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= temp) {
                r--;
            }
            if (l < r) {
                nums[l] = nums[r];
                l++;

            }
            while (l < r && nums[l] < temp) {
                l++;
            }
            if (l < r) {
                nums[r] = nums[l];
                r--;

            }

        }
        nums[l] = temp;
        return l;
    }
}
