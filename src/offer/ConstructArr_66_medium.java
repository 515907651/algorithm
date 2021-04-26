package offer;

import java.util.Arrays;

public class ConstructArr_66_medium {
    // 构建前数组和后数组，结果是前数组和后数组相乘
    public int[] constructArr(int[] a) {
        // 出现的问题在left[i - 1] * a[i - 1]和边界
        if (a == null) {
            return null;
        }
        if (a.length == 0) {
            return new int[a.length];
        }
        int[] result = new int[a.length];
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = 1;
        right[a.length - 1] = 1;
        for (int i = 1; i < a.length; i++) {
            // 问题是，对于第一个数，left应该等于1
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            // 问题是，对于第一个数，left应该等于1
            right[i] = right[i + 1] * a[i + 1];
        }
        for (int i = a.length - 1; i > 0; i--) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

}
