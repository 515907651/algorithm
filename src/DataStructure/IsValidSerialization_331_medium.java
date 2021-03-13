package DataStructure;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidSerialization_331_medium {
    public boolean isValidSerialization1(String preorder) {
        // 用栈来做，当遇到根节点（有两个连续的##）就弹出，加入一个#
        if (preorder == null || preorder.length() == 0){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        int flag = 0;
        for (int i = 0; i < preorder.length(); i++) {
            if (Character.isDigit(preorder.charAt(i))){
                stack.push(preorder.charAt(i));
                flag = 0;
            }
            if (preorder.charAt(i) == '#'){
                flag++;
                if (flag == 1){
                    stack.push('#');
                }
                if (flag == 2){
                    // 弹出##后还可能和前面的形成##
                    stack.pop();
                    stack.pop();
                    while (!stack.isEmpty() && stack.peek() == '#'){
                        stack.pop();
                        stack.pop();
                    }
                    stack.push('#');
                    flag = 0;
                }
            }
        }
        if (stack.size() == 1 && stack.pop() == '#'){
            return true;
        }
        return false;
    }
    public boolean isValidSerialization(String preorder) {
        // 不使用flag
        if (preorder == null || preorder.length() == 0){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < preorder.length(); i++) {
            if (Character.isDigit(preorder.charAt(i))){
                // 还要考虑到非个位数是占用两个字符的
                stack.push(preorder.charAt(i));
                while(i + 1 < preorder.length() && Character.isDigit(preorder.charAt(i))){
                    i++;
                }
            }
            if (preorder.charAt(i) == '#') {
                while (!stack.isEmpty() && stack.peek() == '#'){
                    stack.pop();
                    if (stack.isEmpty()) return false;
                    stack.pop();
                }
                stack.push('#');
            }
        }
        if (stack.size() == 1 && stack.pop() == '#'){
            return true;
        }
        return false;

    }

}
