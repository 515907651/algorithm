package topinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _66_PlusOne_easy {
    // 只要考虑到进位就OK了
    // 对于进位，当当前位为9的时候，变为0，进位1，注意可能一直进位，会造成数组长度+1
    public int[] plusOne(int[] digits) {
        // 太复杂了，当遇到后面不进位的时候已经可以直接终止了
        List<Integer> answer = new ArrayList<>();
        int flag = 0;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                sum = digits[i] + 1 + flag;
            } else {
                sum = digits[i] + flag;
            }
            if (sum == 10) {
                flag = 1;
                answer.add(0);
            } else {
                flag = 0;
                answer.add(sum);
            }
        }
        if (flag == 1) {
            answer.add(1);
        }
        Collections.reverse(answer);
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] plusOne1(int[] digits) {
        // 希望在不进位的时候直接返回
        // 基本思路是
        // 从最低位开始，+1，然后结果对10取余，余0说明进位，继续，否则返回
        // 当所有位上全部+1了，没有返回，说明又多出来一位
        if (digits == null || digits.length == 0) {
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 这一步也太讲究了，如果后面的一直进位，说明都变成了0，那么直接新建一个长度+1的数组，第一步变成1就好了
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
