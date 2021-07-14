package topinterview;

import DataStructure.TreeNode;

public class _124_maxPathSum_hard {
    // 代码看上去很简单，但是很难想，很难写
    // 对于一棵二叉树，他的路径最大值要求出所有路径，然后找到最大的
    // 从底向上看，叶子节点的路径最大值是他本身，非叶子节点的路径值，是他和叶子节点的值之和
    // recur求的是以当前节点为根节点的路径的值
    // 我的一个误解：最大路径可以是根节点的左右子树+根节点+根节点的父节点，这就不是一个路径了。
    // 所以要明确路径的定义，可以简化成当前节点作为根节点，左右子树作为起始和结束节点，递归下去。
    // 还得再看看啊
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recur(root);
        return max;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(recur(root.left), 0);
        int right = Math.max(recur(root.right), 0);
        max = Math.max(root.val + left + right, max);
        return root.val + Math.max(left, right);
    }

}
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
*/
