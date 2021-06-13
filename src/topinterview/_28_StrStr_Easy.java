package topinterview;

public class _28_StrStr_Easy {
    /**
     * 找出一个字符串中另一个字符串出现的位置
     * */
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        for (int i = 0; i + n2 <= n1; i++) {
            boolean flag = true;
            for (int j = 0; j < n2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

}
