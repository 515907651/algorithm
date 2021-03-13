package DataStructure;

import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal_144_medium {
    // List<Integer> result = new LinkedList<>();
    List<Integer> result;
    // 这个result的初始化要么在定义的时候，要么在函数内用this指代。
    public List<Integer> preorderTraversal(TreeNode root) {
        this.result = new LinkedList<>();
        recur(root);
        return result;
    }
    public void recur(TreeNode treeNode){
        if (treeNode == null) return;
        result.add(treeNode.val);
        recur(treeNode.left);
        recur(treeNode.right);
    }
}
