package offer;

import DataStructure.TreeNode;

public class IsBalanced_55_2_easy {
    // 判断左子树和右子树的高度差是否为1
    // 这绝对是递归了，淦
    Boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        // 思路就是求左右两子树的高度，判断高度差
        // 但是左右子树还有左右子树啊，递归
        if (root == null) {
            return true;
        }
        depthOfTree(root);
        return flag;
    }
    private int depthOfTree (TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = depthOfTree(treeNode.left);
        int right = depthOfTree(treeNode.right);
        if (Math.abs(left - right) >= 2){
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}
