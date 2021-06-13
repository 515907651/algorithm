package topinterview;

import org.junit.Test;

public class _8_MyAtoi_Medium {
    // 字符串转数字
    // 返回值有问题，回头再看看TODO
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 去除首尾空格
        String s1 = s.trim();
        // 判断正负号
        // 判断到的位置
        int current = 0;
        if (s1.length() == 0) {
            return 0;
        }
        boolean positive = true;
        int result = 0;
        if (s1.charAt(current) == '-') {
            positive = false;
            current++;
        } else if (s1.charAt(current) == '+') {
            current++;
        }
        while (current < s1.length() && s1.charAt(current) - '0' >= 0 && s1.charAt(current) - '9' <= 0) {
            // 当前字符是数字且未越界
            if (result > Integer.MAX_VALUE/10) {
                result = Integer.MAX_VALUE;
                break;
            }
            result = result * 10 + s1.charAt(current) - '0';
            current++;
        }
        if (positive) {
            return result;
        } else {
            return result == Integer.MAX_VALUE ? Integer.MIN_VALUE : -result;
        }
    }

    @Test
    public void tempTest() {
        System.out.println(myAtoi("-42"));
    }
}
