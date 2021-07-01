package topinterview;

public class _88_merge_easy {
    /**
     * 这个题太骚了，把大的放到后面去，就不需要占用新的空间了*/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int t = m + n - 1;
        while (i >=0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[t] = nums1[i];
                t--;
                i--;
            } else {
                nums1[t] = nums2[j];
                t--;
                j--;
            }
        }
        while (j >= 0) {
            nums1[j] = nums2[j];
            j--;
        }
    }

}
