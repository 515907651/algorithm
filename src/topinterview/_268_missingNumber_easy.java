package topinterview;

public class _268_missingNumber_easy {
    public int missingNumber(int[] nums) {
        // 我的想法是求和再减去nums的和
        int n = nums.length;
        int sum = (n+1)*n/2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

}
