package topinterview;

import DataStructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class _98_isValidBST_medium {
    // 判断是不是搜索二叉树，直接中序遍历，看是否是升序
    // 中间不是升序的时候直接跳出
    // 循环判断条件没写对，pre=root.val 没写对
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        int pre = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }

    long pre = Long.MIN_VALUE;
    public boolean isValidBST1(TreeNode root) {
        // 递归版
        return recur(root);
    }

    private boolean recur(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean l = recur(root.left);
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        boolean r = recur(root.right);
        return l && r;
    }


}
