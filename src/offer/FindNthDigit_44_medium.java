package offer;

public class FindNthDigit_44_medium {
    public int findNthDigit(int n) {
        // 题目不清不楚的
        // 输入一个n，把1-n排列好变成一个数组，然后找数组里位置是n的字符
        // 首先要注意n是从1开始的嗷
        // 还是一个找规律的脑筋急转弯，然而我脑子不好使啊啊
        // 1-9就直接是n
        // 最终还是放弃了挣扎看了题解
        // 对于数字n，首先求出它在字符串中对应的数字
        // 首先确定是几位数
        long num = n;
        long max = 9;
        long size = 1;
        while (true) {
            if (num - max * size < 0){
                break;
            }
            num -= max * size;
            size++;
            max *= 10;
        }
        // 这时size代表数字n的位数
        // num：比如是100以后的第num个字符
        long current = num / size;
        long remainder = num % size;
        long currentNum = (long)Math.pow(10,size-1) + current;
        System.out.println(currentNum);
        if (remainder == 0){
            // 个位数会少1
/*
            if (size ==1) {
                return (int)current;
            }
*/
            return (int)((currentNum - 1) % 10);
        }
        int result = 0;
        // 怎么求该数字的第remainder位，转换为字符串和数字求
        String sNum = new String(String.valueOf(currentNum));
        return sNum.charAt((int)remainder-1) - '0';
    }

}
