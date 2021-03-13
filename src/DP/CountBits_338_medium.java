package DP;

public class CountBits_338_medium {
    // 两种方法，一种是位运算，另一种是动态规划
    // 题解给的动态规划有三种，我傻了，正好学学位运算吧
    public int[] countBits(int num) {
        // 位运算需要了解x&=x-1会消除末尾的1
        int[] result = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            result[i] = counts(i);
        }
        return result;
    }

    public int counts(int num) {
        int i = 0;
        while (num > 0) {
            // 按位与，当二进制位都为1时为1，(x-1)&x正好消除了最低位的1
            num &= num - 1;
            i++;
        }
        return i;
    }

    public int[] countBitsDP1(int num) {
        // 高有效位
        int[] result = new int[num+1];
        int highBit = 0;
        for (int i = 1; i < num+1; i++) {
            if ((i&(i-1))==0){
                highBit = i;
            }
            result[i] = result[i-highBit]+1;
        }
        return result;
    }
    public int[] countBitsDP2(int num) {
        // 低有效位
        // 最低位是否为1可以通过判断奇偶来确定，奇数为1，偶数为0
        // 对应的x%2或者x&1为1时，是奇数
        // 然后通过右移num消除最低位，向右移动1位时，如果原数是偶数，那么1的数量不变（最后一位是0）
        // 如果是奇数，原数的1的数量等于右移后的数量再加1
        int[] result = new int[num+1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i>>1] + (i&1);
        }
        return result;
    }
    public int[] countBitsDP3(int num) {
        // 最低设置位
        // 最低设置位的定义是二进制表示中最低的1所在位
        // x&(x-1)可以将最低位变为0，那么result[x] = result[x&(x-1)]+1
        int[] result = new int[num+1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i&(i-1)]+1;
        }
        return result;
    }


}
