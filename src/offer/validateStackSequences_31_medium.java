package offer;

import java.util.Deque;
import java.util.LinkedList;

public class validateStackSequences_31_medium {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 模拟
        // 建立一个栈，依次push进pushed数组里的数字，同时检查是否等于popped当前的数字，如果相等，pop出来
        // 当pushed全部push进去且popped全部遍历完时，返回true
        // 真的要想清楚所有具体细节再去写，不然很难一次AC
        Deque<Integer> stack = new LinkedList<>();
        int pos = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[pos]){
                stack.pop();
                pos++;
            }
        }
        if (pos == popped.length) return true;
        return false;
    }

}
