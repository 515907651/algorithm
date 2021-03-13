package Arrays;

import java.util.*;

public class AddToArrayForm_989_easy {
    public static void main(String[] args) {

    }

    private static List<Integer> addToArrayForm(int[] A, int K) {
        // 思路
        // 把A转换为数字和K相加，然后转换为list，反转，结果溢出
        List<Integer> result = new ArrayList<>();
        int k = 1;
        int X = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            X += k * A[i];
            k *= 10;
        }
        int temp = X + K;
        while (temp != 0) {
            result.add(temp % 10);
            temp /= 10;
        }
        Collections.reverse(result);
        return result;
    }

    private static List<Integer> addToArrayForm1(int[] A, int K) {
        // 直接运算，不加
        List<Integer> result = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int temp = K % 10;
            K = K / 10;
            if (temp + A[i] >= 10) {
                K++;
            }
            result.add((temp+A[i]) % 10);
        }
        while (K != 0) {
            result.add(K % 10);
            K /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}
