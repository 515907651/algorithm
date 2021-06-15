package topinterview;

import org.junit.Test;

public class _38_CountAndSay_Medium {
    // 思路就是从1一直到n，全给他总结出来
    public String countAndSay(int n) {
        // 只需要记录两个就行，前面的数字和当前的数字，不知道数字的大小，所以用String
        StringBuffer pre = new StringBuffer("1");
        if (n == 1) {
            return "1";
        }
        if (n < 0) {
            return "";
        }
        for (int i = 0; i < n - 1; i++) {
            // 这个要循环n-1次，因为是从1开始的
            // 首先遍历pre
            // 用来记录各个数字的次数
            StringBuffer cur = new StringBuffer();
            int s = 1;
            int j = 0;
            for (j = 0; j < pre.length() - 1; j++) {
                // 最后一个怎么处理？
                if (pre.charAt(j) != pre.charAt(j + 1)) {
                    cur.append(s).append(pre.charAt(j));
                    s = 1;
                } else {
                    s++;
                }
            }
            // 判断最后一个数字，上面没有补最后一个数字，也就是如果重复不补，不重复也没补
            // 这里越界-1
            cur.append(s).append(pre.charAt(j));
            //更新cur
            pre = cur;
        }
        return pre.toString();
    }

    @Test
    public void tempTest() {
        System.out.println(countAndSay(4));
    }
}
