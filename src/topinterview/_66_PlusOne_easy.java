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
// TODO 把题解的方法写一遍，那个真的简洁
}
