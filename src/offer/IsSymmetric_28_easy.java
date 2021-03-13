package offer;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class IsSymmetric_28_easy {
    // 镜像对称，想到的方法是层次遍历二叉树，然后判断结果是否对称
    // 首先是层次遍历二叉树，啊，之前还做过，想不起来了,用个队列吧好像
    // 层次遍历个屁啊，就递归完事了
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return recur(root.left,root.right);
    }
    public boolean recur(TreeNode left, TreeNode right){
        if (left==null&&right==null) return true;
        if (left==null||right==null||left.val!=right.val) return false;
        return recur(left.left,right.right)&&recur(left.right,right.left);
    }
/*
    public List<StringBuilder> levelTravel(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<StringBuilder> list = new ArrayList<>();
        queue.push(root);
        while (!queue.isEmpty()){

        }
    }
*/

}
