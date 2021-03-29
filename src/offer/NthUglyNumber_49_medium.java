package offer;

public class NthUglyNumber_49_medium {
    // 丑数，有点难的，一点思路都没有
    int[] nums = new int[1690];
    public int nthUglyNumber(int n) {
        // 动态规划
        // 当当前数和2，3，4相乘以后，就没有资格再乘一次
        nums[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int ugly;
        for (int i = 1; i < 1690; i++) {
            ugly = Math.min(Math.min(nums[i2] * 2, nums[i5] * 5), nums[i3] * 3);
            nums[i] = ugly;
            System.out.println(ugly);

            if (ugly == nums[i2] * 2){
                i2++;
            }
            if (ugly == nums[i5] * 5){
                i5++;
            }
            if (ugly == nums[i3] * 3){
                i3++;
            }
        }
        return nums[n-1];
    }

}
