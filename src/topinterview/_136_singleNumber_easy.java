package topinterview;

public class _136_singleNumber_easy {
    // 如果熟悉位运算或者做过这个题，那真的是easy题
    // 主要思路是相同的两个数^是0，0和任何数字^都是他本身
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

}
