package offer;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class levelOrder_32_1_medium {
    public int[] levelOrder(TreeNode root) {
        // 这种直接输出全部的层次遍历太简单了，一个queue解决
        // 难得是依次输出每层
        // 两个小问题
        // 1. list<Integer>转int[]
        // 2. queue加入队列是offer，出列是poll
        if (root == null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        TreeNode temp;
        while (!queue.isEmpty()){
            temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if (temp.right != null){
                queue.offer(temp.right);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
/*
        Integer[] result = list.toArray(new Integer[0]);
        // int[] result = (int[]) list.toArray(new int[0]);
        return (int[]) result;
*/
    }

}
