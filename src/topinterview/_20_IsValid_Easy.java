package topinterview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _20_IsValid_Easy {
    /**
     * 判断只包含括号的字符串是否有效.
     * 用栈来做，当遇到同类型的相反括号，出栈，否则入栈，最后如果是空栈就说明合法
     * */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList();
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == '(' && s.charAt(i) == ')' || stack.peek() == '[' && s.charAt(i) == ']' || stack.peek() == '{' && s.charAt(i) == '}') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
