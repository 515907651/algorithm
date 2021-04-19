package offer;

import DataStructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxDepth_55_1_easy {
    // 就是层次遍历，加个标志k就ok了，用到队列
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int k = 0;
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            k++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return k;
    }

}
