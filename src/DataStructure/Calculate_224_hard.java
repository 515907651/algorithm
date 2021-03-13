package DataStructure;

import java.util.Deque;
import java.util.LinkedList;

public class Calculate_224_hard {
    public int calculate(String s) {
        // 难点在于括号，遇到括号应该怎么办
        // 如果是右括号，无所谓；如果是左括号，左括号前面是-的话，括号内的操作都需要变化，因为只有加减，所以加变减，减变加就好了
        // 对应的数乘以-1
        // 用栈来存储括号内加减的变化，如果遇到左括号，且前面是-，入栈-1（还不能只入-1，如果连着两个-号，还要入1），否则入栈1；遇到右括号，出栈
        // 遇到数字的话还要求数字的值，因为不一定是个位数

        Deque<Integer> stack = new LinkedList<>();
        int sign = 1;
        int result = 0;
        int num = 0;
        stack.push(sign);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {

            } else if (s.charAt(i) == '+'){
                sign = stack.peek();
            } else if (s.charAt(i) == '-'){
                sign = -1 * stack.peek();
            } else if (s.charAt(i) == '('){
                stack.push(sign);
            } else if (s.charAt(i) == ')'){
                stack.pop();
            } else {
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                // 上面i++之后，for循环还要i++，这样就跳过了一个，while循环就不会出现这种问题
                result += num * sign;
                num = 0;
                }
        }
        return result;
    }

}
