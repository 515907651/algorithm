package topinterview;

public class _75_sortColors_medium {
    // 我想到的思路是，将0全都放到最前面，2全部放到最后面
    // 思路蛮难想的，和普通双指针不一样
    // 这个模拟的过程是，i依次遍历数组，left代表0的位置，right代表2的位置，遇到0，交换i和left，遇到2， 循 环 交换i和right，因为i是从左边到右边的
    // 如果当前位置交换后为0，因为0本身就想让他在左边，所以可以继续，当交换后当前位置为2，必须要将这个2放到最后，就要不断交换，直至当前位置不为2
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;
        for (int i = 0; i <= right; i++) {
            // 这里有三个遍历，i，left和right
            while (i <= right && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }

}
