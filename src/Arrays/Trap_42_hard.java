package Arrays;

import java.util.Deque;
import java.util.LinkedList;

public class Trap_42_hard {
    // 接雨水
    public int trap(int[] height) {
        // 自己写的暴力算法
        // 思路是遍历数组，在每一个位置向左向右遍历
        // 当前位置的雨水量是min(左边最大值，右边最大值) - height[i];
        int result = 0;
        int maxL = Integer.MIN_VALUE;
        int maxR = Integer.MIN_VALUE;
        if (height == null || height.length <= 2) {
            return result;
        }
        for (int i = 1; i < height.length - 1; i++) {
            // 0位置不可能存住水，因为边界为0，同理，末尾位置也不能存水。
            maxL = Integer.MIN_VALUE;
            maxR = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                // 在左边找最大值
                if (maxL < height[j]) {
                    maxL = height[j];
                }
            }

            for (int j = i + 1; j < height.length; j++) {
                if (maxR < height[j]) {
                    maxR = height[j];
                }
            }
            if (Math.min(maxL, maxR) > height[i]) {
                result += Math.min(maxL, maxR) - height[i];
            }
        }
        return result;
    }
    public int trapDP(int[] height) {
        // dp的方法是先统计出i位置左边的最大值和右边的最大值，用到的时候直接用就ok
        int result = 0;
        if (height == null || height.length <= 2) {
            return result;
        }
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];
        maxL[0] = height[0];
        maxR[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            maxL[i] = Math.max(height[i], maxL[i - 1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            maxR[i] = Math.max(height[i], maxR[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            result += Math.min(maxR[i], maxL[i]) - height[i];
        }
        return result;
    }
    public int trapStack(int[] height) {
        // 先写下思路吧，好像还没想明白
        // 维护一个单调栈，里面放数组的下标，对下标的要求是，下标代表的height[i]是单调递减的，也就是height[i - 1] <= height[i]
        // 遍历数组，当遇到递减的就push进去
        // 遇到一个大于top的，假若这时栈中有两个及两个以上栈帧，记另外一个栈帧为left，那么肯定有height[left] >= height[right](严格递减嘛)
        // 又因为height[i] > height[top]，所以形成了一个左右高，中间低的凹形，可以接水了
        // 但是有一个问题的，比如height[left] == height[top]，这时候没法接水的，是个平的，那么怎么解决呢
        // 回想我们之前求水体积的计算方式，是用min(maxLeft, maxRight) - height[i]，那么如果maxLeft==height[i]<maxRight，求出来的就是0，没有影响的
        // 或者我们可以直接判断一下，如果height[left] == height[top]，直接跳过就行了，但是记得出栈。
        // 重点来了，水的体积怎么求呢，我们不能只求当前这一列的体积，考虑到刚刚的平着的情况，可能多列是平着的，所以我们要用高度乘上宽度去求
        // min(height[left], height[i]) - height[top]是高度，宽度是i - left - 1;
        // 还有什么时候入栈出栈，也蛮复杂的
        int result = 0;
        if (height == null || height.length <= 2) {
            return result;
        }
        int n = height.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 一定注意下标和值的区别
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                if (height[top] == height[left]) {
                    continue;
                } else {
                    result += (Math.min(height[i], height[left]) - height[top]) * (i - left - 1);
                }
            }
            // 放进去的应该是下标
            stack.push(i);
        }
        return result;
    }

}
