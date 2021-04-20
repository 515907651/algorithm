package offer;

public class SingleNumbers_56_1_medium {
    // 异或操作：^
    // 按位比较，相同为0，不同为1
    // 两个相同的数异或为0
    // 有结合律和交换律
    public int singleNumbers1(int[] nums) {
        // 这个是有一个不同的数，很简单，全部取异或就OK
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
    public int[] singleNumbers(int[] nums) {
        // 加强版，有两个数是不同的
        // 解决问题的关键是分组，把两个不同的数字放到不同的组中，其他的是相同的数
        // 先对全部数字进行异或，得到的结果是两个不同数字异或的结果值
        // 再根据其中一位为1的数字进行分组，其他数字该位为1就是一组，不为1就是另一组
        // 因为相同的数字同一位一定相同，不同的数字不同，把不同的数字分开，相同的放在一组
        /*
        *         int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};


作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        * */
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        int target = nums[0];
        // 求两个不同数的异或值
        for (int i = 1; i < n; i++) {
            target = target ^ nums[i];
        }
        // 找到为1的一位
        int div = 1;
        while ((target & div) == 0) {
            // div写成了1
            div <<= 1;
        }
        // 求两个不相同的值
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & div) == 0) {
                result1 = result1 ^ nums[i];
            } else {
                result2 = result2 ^ nums[i];
            }
        }
        return new int[]{result1,result2};
    }


}
