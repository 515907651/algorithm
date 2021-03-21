package offer;

public class CountDigitOne_43_hard {
    // 和脑筋急转弯一样
    // 首先想到的思路是，对于每一个数字，求数字对10取余，如果结果为1，count++；这种复杂度太高了，首先遍历一遍是n，取余是len（n），绝对超时
    // 那么就得找规律
    // 对于一个数字abcde，求百位上的c出现1的次数（要考虑到是从0开始的，加一）
    // 如果c是0，那么c上出现1的次数由高位决定，从0-abcde所有数百位上带1的，有ab*100个
    // 如果c是1，那么c上出现的次数由低位和高位共同决定，高位ab*100，低位de+1
    // 如果c是大于1的，那么c上出现1的次数由高位决定，（ab+1）* 100
    public int countDigitOne(int n) {
        // 照着写了一遍，具体循环思想还是得再想想
        if (n < 1) {
            return 0;
        }
        int i = 1;
        int count = 0;
        int num = n;
        while (num != 0){
            if (num%10 == 0) {
                count += num/10*i;
            }
            if (num%10 == 1) {
                count += num/10*i + (n%i) + 1;
            }
            if (num%10 > 1) {
                count += (num/10 + 1)*i;
            }
            num = num / 10;
            i *= 10;
        }
        return count;
    }
    public void separateNum(int num) {
        // 想理清思路，先写个求各个位上的数

        int temp = num;
        int current = 0;
        while(temp > 0){
            current = temp%10;
            temp = temp/10;

        }
    }
    public void separateNum1(int num) {
        // 在扩展一下，求各个位上的值，这次要加上他的位数，比如100,10000这种
        int i = 1;
        int temp = num;
        int current = 0;
        while(temp > 0){
            current = temp%10*i;
            temp = temp/10;
            i *= 10;
        }
    }


}
