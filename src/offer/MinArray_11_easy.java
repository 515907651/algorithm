package offer;

public class MinArray_11_easy {
    // 二分法查找最小值
    public int minArray(int[] numbers) {
        int left  = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] < numbers[right]) {
                // 这时候最小值在左边，但是可能是mid
                right = mid;
            }else if (numbers[mid] > numbers[right]) {
                // 最小值在右边且不可能是mid
                left = mid + 1;
            } else {
                // 相等的话看right左边的那个数字
                right--;
            }
        }
        return numbers[left];
    }

}
