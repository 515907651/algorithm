package topinterview;

import java.util.Arrays;

public class _324_wiggleSort_medium {
    // 我的思路是将数组先排序，然后分成小的部分和大的部分，依次插入小的和大的
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        Arrays.sort(nums);
        int n = nums.length;
        // 还要分奇偶啊，偶数的话，小大放就行了，奇数的话
        // 不用分奇偶，都先最小，再最大
        // 一个坑，因为先放小的，所以小的数量应该大于大的，所以中点的选择在奇数的时候，应该让小的多
        int[] result = new int[n];
        int l = (n  + 1)/ 2 - 1;
        int r = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result[i] = nums[l--];
            } else {
                result[i] = nums[r--];
            }
        }
        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }

}
