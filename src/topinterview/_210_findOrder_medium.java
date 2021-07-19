package topinterview;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _210_findOrder_medium {
    // 熟悉的课程完成问题，区别是要记录下课程完成的顺序，感觉那个BFS比较合适
    // 再看看stream的各种操作
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 特殊情况判断
        if (numCourses == 0) {
            // 就没有课
            return new int[0];
        }
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            // 没有前置课程关系，直接返回课程
            int[] special = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                special[i] = i;
            }
            return special;
        }
        // 存储边的结构，第一层n对应课程号，里面存储当前课程号的前置课程
        List<List<Integer>> edges = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new LinkedList<>());
        }
        // 记录下当前课程的前置课程数，也就是入度
        int[] inDeg = new int[numCourses];
        // 初始化边和入度
        for (int[] temp : prerequisites) {
            // 例子：[1,0]，0是前置课程，1是当前课程
            edges.get(temp[1]).add(temp[0]);
            inDeg[temp[0]]++;
        }
        // BFS
        Deque<Integer> queue = new LinkedList<>();
        // 结果数组，考虑着用个list来存储，最后判断一下长度，看是否能完成，然后转成数组
        // 其实用int[]更好，index作为长度
        List<Integer> list = new LinkedList<>();
        // 首先将所有入度为0的课程加入
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            // 每次将入度为0的取出，加入ans并且去更新入度，当更新完的入度为0时，加入
            int current = queue.pop();
            list.add(current);
            for (int temp : edges.get(current)) {
                inDeg[temp]--;
                if (inDeg[temp] == 0) {
                    queue.offer(temp);
                }
            }
        }
        if (list.size() == numCourses) {
            return list.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[0];
        }
    }

}
