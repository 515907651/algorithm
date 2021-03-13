package Arrays;

import java.util.Arrays;

public class MaximumProduct_628_easy {
    public static void main(String[] args) {
        int[] nums = new int[]{-100,-98,-1,2,3,4};
        System.out.println(maximumProduct(nums));
    }
    private static int maximumProduct(int[] nums){
        // 比较麻烦的就是数组里面有负数
        // 乘积最大的话，要分情况讨论
        // 1.乘积是个正数，可能的情况是三个都是正数或者两负一正
        // 2.乘积是个负数，可能的情况是三个都是负数或者两正一负
        // 能不能把数组直接排序，然后直接取最大的三个相乘就完事了吧
        Arrays.sort(nums);
        int result = 1;
        for (int i = nums.length-1; i > nums.length-4 ; i--) {
            result*=nums[i];
        }
        // 我再加个负数最大
        int result2 = 1;
        for (int i = 0; i < 2; i++) {
            result2*=nums[i];
        }
        result2*=nums[nums.length-1];
        result=Math.max(result,result2);
        return result;

    }
}
