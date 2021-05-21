package offer;

import org.junit.Test;

import java.util.Arrays;

public class GetLeastNumbers_40_easy {
    // 最简单的方法是调用排序函数，然后取前K个数字
    // 复杂一点的是用快排，只考虑一边
    // 先写一便快排，复习一下子
    public void quickSort(int[] nums, int l ,int r) {
        if (l >= r) {
            return;
        } else {
            int init = partition(nums, l, r);
            quickSort(nums, l, init - 1);
            quickSort(nums, init + 1, r);

        }
    }

    private int partition(int[] nums, int l, int r) {

        int temp = nums[l];
        while (l < r) {
            while (nums[r] >= temp && l < r) {
                r--;
            }
            if (l < r) {
                nums[l] = nums[r];
                l++;
            }
            while (nums[l] <= temp && l < r) {
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
    @Test
    public void tempTest(){
        int[] array = new int[] {3,5,4,1,7,9};
        int k = 3;
        quickSortK(array,0, array.length -1, k);
        for (int i = 0; i < k; i++) {
            System.out.println(array[i]);
        }
    }
    // 用快排解决一下前k个最小值
    public int[] getLeastNumbers(int[] arr, int k) {
        // 前k个，对应的最后一个index应该是k - 1
        int index = k - 1;
        quickSortK(arr, 0, arr.length - 1, index);
        return Arrays.copyOf(arr, k);
    }

    private void quickSortK(int[] arr, int l, int r, int index) {
        if (l < r) {
            int init = partitionK(arr, l, r);
            if (init == index) {
                return;
            } else if (init < index) {
                quickSortK(arr, init + 1, r, index);
            } else {
                quickSortK(arr, l, init - 1, index);
            }
        }
    }

    private int partitionK(int[] arr, int l, int r) {
        int temp = arr[l];
        while (l < r) {
            while (arr[r] >= temp && l < r) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
                l++;
            }
            while (arr[l] <= temp && l < r) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }
        arr[l] = temp;
        return l;
    }
}
