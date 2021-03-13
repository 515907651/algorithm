package offer;

import DataStructure.TreeNode;

public class MirrorTree_27_easy {
    TreeNode temp;
    public TreeNode mirrorTree(TreeNode root) {
        // 反转二叉树的话，感觉是要递归的，头大
        // swap(node.left,node.right) 继续递归，结束条件是node为空，我真是小天才
        recur(root);
        return root;
    }
    public void recur(TreeNode node){
        if (node==null) return;
        temp = node.left;
        node.left = node.right;
        node.right = temp;
        recur(node.left);
        recur(node.right);
    }
    public TreeNode mirrorTree1(TreeNode root) {
        // 看看人家写的，优美，简洁。自己写的就是shit
        if (root == null) {
            return null;
        }
        TreeNode leftRoot = mirrorTree(root.right);
        TreeNode rightRoot = mirrorTree(root.left);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
}
