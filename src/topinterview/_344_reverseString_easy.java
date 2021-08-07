package topinterview;

public class _344_reverseString_easy {
    // 太简单了，反转字符串，学c的时候就做过
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
        }
    }

}
