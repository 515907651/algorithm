package offer;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum_34_medium {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        // 深度优先搜索，深度优先搜索用递归或者栈来实现的我记得
        // 从根节点遍历到叶子节点，当路径上的值和为target时，保存这个路径。
        // 蛮难写的
        // 先把结果定义好吧。
        DFS(root, 0, target);
        return result;
    }

    private void DFS(TreeNode root, int sum, int target) {
        if (root == null) {
            return;
        }
        sum += root.val;
        path.add(root.val);
        if (sum == target && root.left == null && root.right == null) {
            // 加入条件是叶子节点
            // new ArrayList<>(path)，不然为空
            result.add(new ArrayList<>(path));
        }
        DFS(root.left, sum, target);
        DFS(root.right, sum, target);
        // 这句话好好体会
        path.remove(path.size() - 1);
    }

}
