package topinterview;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _84_largestRectangleArea_hard {
    /**
     * 暴力解法
     * 首先遍历数组，在每个位置像两边扩散，直到两边高度小于当前位置
     * 几个注意的点，i和j的值*/
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int l = heights.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            int width = 1;
            int j = i - 1;
            while (j >= 0) {
                // 向左扩散
                if (heights[j] >= heights[i]) {
                    // 左边位置大于当前位置
                    width++;
                    j--;
                } else {
                    break;
                }
            }
            j = i + 1;
            while (j < l) {
                if (heights[j] >= heights[i]) {
                    j++;
                    width++;
                } else {
                    break;
                }
            }
            max = Math.max(max, width * heights[i]);
        }
        return max;
    }

    /**
     * 题解方法
     * 利用单调栈，一次遍历，记录下左右边界
     * */
    public int largestRectangleArea1(int[] heights) {
        // 再看看
        // 模拟一遍，首先建立一个栈，第一次将数字位置直接加入，后面的数字判断大小，比当前数字大就直接加入，加入的时候更新这个数字的左边为栈顶元素，如果为空就是-1
        // 比当前数字小就出栈，并且更新右边界，出栈的右边界是i。
        // 这个题里有几个小trick，左右边界的值，-1和n
        // 一个问题是它怎么解决的重复问题，大于等于的时候就弹出了，模拟一下就知道了，最后一个重复的，左边界是最左边，右边界是最右边
        // 一个比较关键的点是什么时候更新左右边界，弹出的时候更新右边界为当前位置，加入的时候更新左边界
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int length = heights.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(right, length);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            // 这个地方的逻辑蛮复杂
            // 当不空且小于的时候，更新右边界并弹出
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            // 遇到合适的加入，并且更新右边界
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]) ;
        }
        return ans;
    }
    }
