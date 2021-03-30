package sort;

// 理解倒是很容易理解，但是代码有点难写的
// 先整个迭代版本
public class MergeSort {
    public void mergeSort1(int[] nums) {
        // 先分解，对分解后的排序，再合并
        // 看不明白，先把代码贴过来吧
        // 代码我也找不到了，淦

    }
    public void mergeSortRe(int[] nums) {
        // 我还想怎么在中间不利用临时数组，结果这里用上了
        if (nums == null || nums.length < 2) {
            return;
        }
        int[] temp = new int[nums.length];
        mergeSortRe1(nums, 0, nums.length-1, temp);

    }
    public void mergeSortRe1(int[] nums, int start, int end, int[] temp){
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSortRe1(nums, start, mid, temp);
            mergeSortRe1(nums, mid + 1, end, temp);
            mergeSortRe2(nums, start, mid, end, temp);
        }
    }

    private void mergeSortRe2(int[] nums, int start, int mid, int end, int[] temp) {
        int i = start;
        int j = mid + 1;
        int m = mid;
        int n = end;
        int k = 0;
        while (i <= m && j <= n){
            if (nums[i] < nums[j]) {
                temp[k] = nums[i];
                k++;
                i++;
            } else {
                temp[k] = nums[j];
                k++;
                j++;
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
        for (int l = 0; l < end; l++) {
            nums[l + start] = temp[l];
        }
    }

    public int[] mergeArray(int[] a, int[] b){
        // 先整个合并两个有序数组
        int n1 = a.length;
        int n2 = b.length;
        int[] result = new int[n1+n2];
        // i代表a的索引，j代表b的索引，k代表result的索引
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (a[i] > b[j]) {
                result[k] = b[j];
                k++;
                j++;
            } else {
                result[k] = a[i];
                k++;
                i++;
            }
        }
        while (i < n1){
            result[k++] = a[i++];
        }
        while (j < n2){
            result[k++] = b[j++];
        }
        return result;
    }
    public void mergeSort2(int[] A, int m, int[] B, int n) {
        // 直接从后往前补，没什么坑
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0){
            if (A[i] > B[j]){
                A[k] = A[i];
                k--;
                i--;
            } else {
                A[k] = B[j];
                k--;
                j--;
            }
        }
        while (j >= 0){
            A[k] = B[j];
            k--;
            j--;
        }
    }
}
