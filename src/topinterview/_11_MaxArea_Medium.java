package topinterview;

public class _11_MaxArea_Medium {
    // 还以为是盛雨水问题，结果就一简单的求面积
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int temp = (right - left) * Math.min(height[left], height[right]);
            if (temp >= max) {
                max = temp;
            }
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}
