package topinterview;

public class _14_LongestCommonPrefix_Easy {
    // 思路是遍历所有字符串，如果相同，指针++，不相同或者遇到末尾就跳出，从0到指针位置就是公共前缀

    public String longestCommonPrefix(String[] strs) {
        // 首先特殊情况
        // 只有一个字符串的话，公共前缀就是他本身
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int minLength = Integer.MAX_VALUE;
        int last = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }
        for (int i = 0; i < minLength; i++) {
            // 这里可以用二分法来做
            char temp = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != temp) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                last++;
            } else {
                break;
            }
        }
        return strs[0].substring(0,last);
    }

}
