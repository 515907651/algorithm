package offer;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder_2_easy {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int sizeOfLevel = queue.size();
            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode parent = queue.poll();
                temp.add(parent.val);
                if (parent.left != null){
                    queue.offer(parent.left);
                }
                if (parent.right != null){
                    queue.offer(parent.right);
                }
            }
            list.add(temp);
        }
        return list;
    }

}
