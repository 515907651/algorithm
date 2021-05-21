package offer;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWords_58_medium {
    public String reverseWords(String s) {
        // 三步
        // 首先去掉多余的空格
        // 然后分割字符串
        // 反转字符串
        if (s == null || s.length() == 0) {
            return null;
        }
        s.trim();
        String[] temp = s.split(" +");
        Collections.reverse(Arrays.asList(temp));
        return String.join(" ", temp);
    }

}
