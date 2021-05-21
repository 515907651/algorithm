package offer;

public class Exchange_21_easy {
    public int[] exchange(int[] nums) {
        // 双指针，一指针找偶数，一指针找奇数，当前者为偶数，后者为奇数时，互相交换
        int left = 0;
        int right = nums.length-1;
        int temp = 0;
        while (left<right){
            // 要先交换在++和--，否则有越界的可能
            if (nums[left]%2==0&&nums[right]%2==1){
                temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
            if (nums[left]%2==1) left++;
            if (nums[right]%2==0) right--;
        }
        return nums;
    }
}
