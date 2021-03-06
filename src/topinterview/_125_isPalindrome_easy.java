package topinterview;

public class _125_isPalindrome_easy {
    // 这个题可不是easy，涉及到很多Character函数的调用
    // 我最开始的想法是，字符串去空格，然后双指针判断，题解的思路是跳过空格
    // 首先是特殊情况判断，当字符串为null或者长度为0，直接返回true
    // character中的函数isLetterOrDigit可以判断是否为数字或者字母
    // character中的函数toLowerCase将字母转换为小写，数字不变
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right&& !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }

}
