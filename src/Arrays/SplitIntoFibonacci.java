package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
        形式上，斐波那契式序列是一个非负整数列表 F，且满足：
        0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
        F.length >= 3；
        对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
        另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
        返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
*/
//842
//也不难吧，首先确定，如果有结果，那么序列块个数一定大于等于3
//0这种特殊情况
//不考虑0的话，从第一个开始，数字长度由1到n判断
//还要考虑到第一个和第二个的位数可以为任意数啊，淦
//直接干死了，抄题解，看懂就OK
public class SplitIntoFibonacci {
    public static void main(String[] args) {

    }

        public static List<Integer> splitIntoFibonacci(String S) {
            List<Integer> list = new ArrayList<Integer>();
            backtrack(list, S, S.length(), 0, 0, 0);
            return list;
        }

        public static boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
            if (index == length) {
                //当数组整个拆完了，如果有>=3个数字，那么是斐波那契数列
                return list.size() >= 3;
            }
            long currLong = 0;
            //用来控制进制
            for (int i = index; i < length; i++) {
                if (i > index && S.charAt(index) == '0') {
                    //如果有数单独为0，直接break？
                    break;
                }
                currLong = currLong * 10 + S.charAt(i) - '0';
                if (currLong > Integer.MAX_VALUE) {
                    //当超过整数范围，直接返回false
                    break;
                }
                int curr = (int) currLong;
                if (list.size() >= 2) {
                    if (curr < sum) {
                        //小于sum的话，可以继续加数
                        continue;
                    } else if (curr > sum) {
                        //大于sum的话就没救了
                        break;
                    }
                }
                list.add(curr);//既不大于，又不小于，sum=cur，归入列表
                if (backtrack(list, S, length, i + 1, prev + curr, curr)) {
                    //接着往下判断
                    return true;
                } else {
                    list.remove(list.size() - 1);
                }
            }
            return false;
        }


}
