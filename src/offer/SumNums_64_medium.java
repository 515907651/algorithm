package offer;

public class SumNums_64_medium {
    public int sumNums(int n) {
        // 求前n项和，要求各种东西都不能用，只能简单的加减
        // 如果可以用判断语句
        // return n == 0 ? 0 : sumNums(n - 1) + n;
        // 现在不许用判断语句，利用&&当前者为真则不执行后者的特点
        boolean f = (n > 0) && (n += sumNums(n - 1)) > 0;
        return n;
    }

}
