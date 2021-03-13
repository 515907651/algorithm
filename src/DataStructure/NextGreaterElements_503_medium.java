package DataStructure;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElements_503_medium {
    public int[] nextGreaterElements(int[] nums) {
        // 参见496，简单版的
        // 还是蛮难的，要用到单调栈
        // 单调栈，顾名思义，就是栈中的元素是单调的，我还以为是系统自带的结构，结果是自己构建
        // 本题栈中存储的是数组的下标，下标对应的nums是单调的，但是下标不是
        // 题目里说是循环数组，所以一些数字的下一个最大值应该找完自己后面的再去找前面的。
        // 遍历数组的过程是，对于当前位置的nums[i]，如果stack为空，把i加入stack
        // 如果stack不为空且nums[i]大于stack中的j对应的nums[stack.peek()]，那么nums[i]就是对应的第一个最大值，然后依次弹出所有栈中符合条件的值
        // 利用result来存储结果，result初始化为-1，意味着找不到
        if (nums==null) return null;// 当n==0的时候，要返回空数组而不是null
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2*n-1; i++) {
            while (!stack.isEmpty()&&nums[i%n]>nums[stack.peek()]){
                result[stack.pop()] = nums[i%n];
            }
            stack.push(i%n);//这句话放的位置也有讲究啊
        }
        return result;
    }

}
