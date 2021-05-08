package offer;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCount_13_medium {
    // 广度优先搜索，不会做啊，做过一遍了还是不会，背吧
    // 找能够到达的格子数
    public int movingCount(int m, int n, int k) {
        // 广度优先搜索，肯定是队列啦
        int ans = 0;
        // 标志数组，代表数组当前位置是否被访问过
        boolean[][] visited = new boolean[m][n];
        // 队列，存放要访问的节点
        Queue<int[]> queue = new LinkedList<>();
        int[] root = new int[]{0, 0};
        queue.offer(root);
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int sum = getSum(temp[1]) + getSum(temp[0]);
            if (temp[0] >= m || temp[1] >= n || sum > k || visited[temp[0]][temp[1]]) {
                continue;
            }
            ans++;
            visited[temp[0]][temp[1]] = true;
            queue.offer(new int[]{temp[0] + 1, temp[1]});
            queue.offer(new int[]{temp[0], temp[1] + 1});
        }
        return ans;
    }
    public int getSum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
