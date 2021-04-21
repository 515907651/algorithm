package offer;

public class MaxQueue_59_medium {
    // 实现一个可以求最大值的队列，我想用list来着，先用数组实现一下,list无法实现记录头尾位置吧
    private int[] array;
    private int left;
    private int right;
    public MaxQueue_59_medium() {
        array = new int[2000];
        left = 0;
        right = 0;
    }

    public int max_value() {
        if (left == right) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = max > array[i] ? max : array[i];
        }
        return max;
    }

    public void push_back(int value) {
        array[right++] = value;
    }

    public int pop_front() {
        if (left == right) {
            return -1;
        }
        return array[left++];
    }

}
