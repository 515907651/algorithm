package topinterview;

public class _238_productExceptSelf_medium {
    // 最先想到的是求出所有数的乘积，然后除以当前数
    // 但是要考虑到其他数字为0的情况
    // 题解给的方法是记录左右累积
    public int[] productExceptSelf(int[] nums) {
        // 空间复杂度为O(N)
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        for (int i = n - 2; i >= 0 ; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }


    public int[] productExceptSelf1(int[] nums) {
        // 空间复杂度为O(1)
        // 直接在answer数组上操作，不新建left和right数组
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R = R * nums[i];
        }
        return ans;
    }
    }

