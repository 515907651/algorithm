package Arrays;

import java.util.LinkedList;
import java.util.List;

public class RemoveDuplicates_1047_easy {
    public String removeDuplicates(String S) {
        // 字符串无法更改，只能转成其他的
        // 两种思路，一种是转成char[]，然后删除重复的，但是数组的删除操作需要移动后面的一堆
        // 用list的话呢，转成char[]再转成list，机制嗷
        // 还有一种是StringBuilder，依次往StringBuilder里放，不行，还是要判断放进去的和后面的是否重复
        // 递归的话又应该怎么写呢
        // 题解给的思路是用栈，而且StringBuffer类自带栈，果然10分钟做不出来就得看题解，不然思路不对，就是浪费时间
/*
        if (S==null||S.length()==0) return S;
        int i = 0;
        char[] c = S.toCharArray();
        List<Character> list = new LinkedList();
        for (int j = 0; i < c.length; i++) {
            list.add(c[j]);
        }
        while (list.)
*/
        StringBuffer stack = new StringBuffer();
        int top = -1;
/*
        while (i<S.length()){
            // 都有i++，为什么不直接用for循环，真的蠢
            if (top==-1){
                stack.append(S.charAt(i));
                i++;
                top++;
            } else if (stack.charAt(top)==S.charAt(i)){
                stack.deleteCharAt(top);
                top--;
                i++;
            } else {
                stack.append(S.charAt(i));
                i++;
                top++;
            }
        }
*/
        for (int i = 0; i < S.length(); i++) {
            if (top>=0&&stack.charAt(top)==S.charAt(i)){
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(S.charAt(i));
                top++;
            }
        }
        return stack.toString();
    }

}
