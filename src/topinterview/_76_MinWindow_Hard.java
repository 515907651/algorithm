package topinterview;

public class _76_MinWindow_Hard {
    // 滑动窗口
    // 大体思路是，当窗口内包含所有目标字符串元素时，记录该子串，滑动窗口左边界右移，直到不再包含所有
    // 然后滑动窗口右边界右移，直到包含所有元素，记录，重复上面的过程
    public String minWindow(String s, String t) {
        if (s == null || t == null || t == "" || s == "") {
            return "";
        }
        int sl = s.length();
        int tl = t.length();
        if (sl < tl) {
            // 当s长度小于t的时候，肯定不包含所有，直接返回空字符串
            return "";
        }
        // 要解决判断包含元素的问题，我想到的是hashmap，但是判断的时候很麻烦，一个一个遍历
        // 题解利用数组判断，思路蛮巧妙的
        // ascii码只有120多个，用128代表每个符号
        int[] need = new int[128];
        int[] have = new int[128];

        // 记录目标数组中各个符号出现的次数
        for (int i = 0; i < tl; i++) {
            need[t.charAt(i)]++;
        }

        // 一些变量，左右边界，子串的最小长度，子串中包含字符的数量，子串的起点
        int left = 0;
        int right = 0;
        int min = sl + 1;
        int count = 0;
        int start = 0;
        while (right < sl) {
            // 当前字符
            char r = s.charAt(right);
            if (need[r] == 0) {
                // 如果不需要当前字符，直接right++就ok了
                right++;
                continue;
            }
            // 需要当前字符的话
            if (have[r] < need[r]) {
                // 当前子串内少了该字符，那么就加上他，总数+1
                count++;
            }
            // 如果多了，那么没有关系，加上就行，只要count确定
            have[r]++;
            right++;
            while (count == tl) {
                // 子串中包含了所有需要的字符
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                // 这时候需要缩窗了，把左边界右移
                char l = s.charAt(left);
                // 如果当前字符不是t中的，直接去掉
                if (need[l] == 0) {
                    left++;
                    continue;
                }
                // 如果当前字符是t中的，而且数量等于t中的数量，这个时候count就要减一了，因为去掉了需要的
                if (have[l] == need[l]) {
                    count--;
                }
                // 其他情况就是是t中的，但是数量大于t中的数量，直接去掉就ok
                left++;
                have[l]--;
            }

        }
        // 最后判断一下min值，如果min值没有变，还是最长，说明不包含
        if (min == sl + 1) {
            return "";
        }
        return s.substring(start, start + min);
    }

}
