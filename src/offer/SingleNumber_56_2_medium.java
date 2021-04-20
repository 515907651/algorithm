package offer;

public class SingleNumber_56_2_medium {
    // 一个数字出现一次，其他数字出现三次
    // 思路就是把所有的数字各个位上的1加起来，因为其他数字出现了3次，对3取余，得到的就是目标数字的值
    public int singleNumber(int[] nums) {
        // 用来存放各个位上的1的数量
        int[] counts = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                // counts[j] += nums[i] & 1;没写+号
                counts[j] += nums[i] & 1;
                // 两个>和三个>有什么区别啊
                nums[i] = nums[i] >> 1;
            }
        }
        // 对3取余
        for (int i = 0; i < 32; i++) {
            counts[i] %= 3;
        }
        // 复原
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // 这个地方还蛮难想的，counts中存放的是从低位到高位的
            // 那么复原的时候，应该先从高位开始，也就是从末尾开始，把1加上去。
            result <<= 1;
            result |= counts[32 - i];
        }
        return result;
    }

}
