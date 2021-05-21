package offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring_48_medium {
    // 最熟悉的滑动窗口，他lei了，仿佛看到了亲人
    // 没有AC，淦，设置个max试试
    // 几种不同的情况
    // 全部重复，那么窗口大小就是1
    // 我没考虑到的
    // 淦，缩窗想不出来
    // 我的想法应该没问题，窗口大小只增长，不减少，最后窗口的大小就是长度
    public int lengthOfLongestSubstring(String s) {
        // 还是不能一遍ac
        // 要进行缩窗啊。
        // 这个方法不对的，比如pwwk这种情况下，无法排除ww的重复，必须缩窗
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int left = 0;
        int right = 0;
        int max = -1;
        HashSet<Character> set = new HashSet<>();
        while (right < n) {
            if (set.contains(s.charAt(right))) {

                set.remove(s.charAt(left));
                set.add(s.charAt(right));
                left++;
                right++;
            } else {
                set.add(s.charAt(right));
                right++;
            }
        }
        System.out.println(left);
        System.out.println(right);
        return right - left ;
    }

    @Test
    public void tempTest() {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring1(String s) {
        // 还是老老实实缩窗吧，慢点就慢点
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int left = 0;
        int right = 0;
        int max = -1;
        HashSet<Character> set = new HashSet<>();
        while (right < n) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - left );
        }
        return max;
    }

}
