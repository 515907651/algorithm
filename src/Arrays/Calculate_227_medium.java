package Arrays;

import java.util.Deque;
import java.util.LinkedList;

public class Calculate_227_medium {
    public int calculate(String s) {
        // 先算出所有的乘除运算，再把所有的结果加减起来
        // 用栈来实现，当符号是加减时，将后面的数入栈，当是乘除时，出栈栈顶的数字和乘除号后面的数字运算，运算完入栈，当遍历完字符串时，将所有数字出栈相加
        // while循环有坑
        if (s == null||s.length() == 0){
            return 0;
        }
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        int current = 0;
        // 求第一个数字的值
        int num = 0;
        char preSign = '+';
        boolean flag = true;
        // 第一个数字什么时候入栈呢，循环前还是循环里面
        while (current < s.length()){
            if (Character.isDigit(s.charAt(current))){
                while((current<s.length())&&Character.isDigit(s.charAt(current))){
                    num = num * 10 + s.charAt(current) - '0';
                    current++;
                }
            } else if (s.charAt(current) == ' ') {
                while (s.charAt(current) == ' ') {
                    current++;
                }
            }
            if (!Character.isDigit(s.charAt(current))&&s.charAt(current) != ' '|| current == s.length() - 1&&current<s.length()){
                switch (preSign) {
                    case ('+'): {
                        stack.push(num);
                        break;
                    }
                    case ('-'): {
                        stack.push(num * -1);
                        break;
                    }
                    case ('*'): {
                        stack.push(num * stack.pop());
                        break;
                    }
                    case ('/'): {
                        stack.push(stack.pop() / num);
                        break;
                    }
                }
                num = 0;
                preSign = s.charAt(current);
                System.out.println(preSign);
                current++;
            }
        }
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
    public int calculate1(String s) {
        // 先算出所有的乘除运算，再把所有的结果加减起来
        // 用栈来实现，当符号是加减时，将后面的数入栈，当是乘除时，出栈栈顶的数字和乘除号后面的数字运算，运算完入栈，当遍历完字符串时，将所有数字出栈相加
        // while循环有坑
        // 用for循环写一下，球球你了，ac吧
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        // 求第一个数字的值
        int num = 0;
        char preSign = '+';
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // 字符就只有三种情况，数字、空格、符号
            // 当遇到空格的时候，什么都不做，跳过去
            // 当遇到数字的时候，因为数字可能是一个多位的数，所以要求他的具体值，累加即可
            // 遇到符号，就把之前求出的数字和栈中的数字以之前的符号进行操作，并且更新符号，符号初始值是'+'
            if (s.charAt(i) == ' '){
                continue;
            }
            if (Character.isDigit(s.charAt(i))){
                num += num * 10 + s.charAt(i) - '0';
            }
            if (s.charAt(i) != ' ' && !Character.isDigit(s.charAt(i)) || i == n - 1){
                switch (preSign) {
                    case ('+'): {
                        stack.push(num);
                        break;
                    }
                    case ('-'): {
                        stack.push(num * -1);
                        break;
                    }
                    case ('*'): {
                        stack.push(num * stack.pop());
                        System.out.println(stack.peek());
                        break;
                    }
                    case ('/'): {
                        stack.push(stack.pop() / num);
                        break;
                    }
                }
                num = 0;
                preSign = s.charAt(i);
            }
        }
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;

    }
}
