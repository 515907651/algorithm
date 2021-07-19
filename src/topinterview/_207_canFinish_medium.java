package topinterview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _207_canFinish_medium {
    // 有向图的搜索
    // 首先将前置关系抽象成有向图的边，只要图中没有环就可以
    // 难点是数据结构，边用List<list<Integer>>存储，第一层list对应的是各个课程，依次加入时，下标就是对应的下标
    // 第二个list对应的是关系
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 首先是广度优先搜索
        // 思路是首先遍历前置，将每个课程的入度记录下来，然后将入度为0的加入队列，每次弹出时，将以该课程为前置的课程的入度--，如果变为0加入队列
        // 最后如果能全部为0，说明无环
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        List<List<Integer>> edges = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new LinkedList<>());
        }
        int[] inDeg = new int[numCourses];
        for (int[] temp : prerequisites) {
            // 这个地方多看看
            // 题中给的是[1,0]，如果想学1，先学0，也就是边的起点是0，终点是1
            edges.get(temp[1]).add(temp[0]);
            inDeg[temp[0]]++;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int cur = queue.poll();
            // 遍历以该课程为起点的边，将终点--
            for (int temp : edges.get(cur)) {
                inDeg[temp]--;
                if (inDeg[temp] == 0) {
                    queue.offer(temp);
                }
            }
        }
        return visited == numCourses;
    }

    boolean valid = true;
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        // 深度优先搜索
        // 从一个节点开始dfs，当该节点的所有指向没有搜索完时，标记为搜索中，搜索完标记成完成，
        // 对于它的子节点进行DFS时，如果发现子节点中有搜索中的，即子节点的父节点和子节点都正在搜索，说明有环，不能完成
        List<List<Integer>> edges = new LinkedList<>();
        // visited表示状态，分别为0,1,2，代表未搜索，搜索中和已搜索
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // 初始化边
            edges.add(new LinkedList<>());
        }
        for (int[] temp : prerequisites) {
            edges.get(temp[1]).add(temp[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            // 依次遍历，当出现环的时候跳出
            dfs(i, edges, visited);
        }
        return valid;
    }

    private void dfs(int i, List<List<Integer>> edges, int[] visited) {
        // 首先标记为搜索中
        visited[i] = 1;
        // 对当前节点进行搜索
        for (int v : edges.get(i)) {
            if (visited[v] == 1) {
                // 有环
                valid = false;
                return;
            } else if (visited[v] == 0) {
                dfs(v, edges, visited);
                if (!valid) {
                    // 子节点中有环
                    return;
                }
            }
        }
        visited[i] = 2;
    }
}
