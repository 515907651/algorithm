package offer;

import DataStructure.TreeNode;

public class BuildTree_07_medium {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 重建先遍历preorder找到根节点，然后再inorder中找到根节点的位置，将inorder分成左右两部分，对左右两部分重复
        // left 和right用来在preorder中找到子树部分
        // 要记录inorder和preorder中的左右子树位置啊，只用一个index还是不太行
        return recur(preorder, inorder, 0, inorder.length, 0, preorder.length);
    }
    private TreeNode recur(int[] preorder, int [] inorder, int iLeft, int iRight, int pLeft, int pRgiht) {
        if (pLeft == pRgiht) {
            return null;
        }
        // 新建一个树节点，第一个节点肯定是根节点
        TreeNode root = new TreeNode(preorder[pLeft]);
        // 找到inorder中根节点位置
        int preRoot = preorder[pLeft];
        // inRoot是inorder中根节点的索引
        int inRoot = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (preRoot == inorder[i]) {
                inRoot = i;
            }
        }
        // 将inorder和preorder分为左右两子树
        root.left = recur(preorder, inorder, iLeft, inRoot - 1, pLeft + 1, pLeft + inRoot - iLeft + 1);
        root.right = recur(preorder, inorder, inRoot + 1, iRight, pLeft + inRoot - iLeft + 1, pRgiht);
        return root;
    }

}
/*
* 以前写的，更符合我的思路
* class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode result = buildTree2(0,0,inorder.length-1,preorder,inorder);
        return result;
    }
        public TreeNode buildTree2(int root, int left, int right, int[] preOrder, int[] inOrder){
        if(left>right) return null;
        int rootIndex = 0;
        for(int i = 0;i < inOrder.length;i++){
            if(preOrder[root]==inOrder[i]) rootIndex = i;
        }
        TreeNode treeRoot = new TreeNode(inOrder[rootIndex]);
        treeRoot.left = buildTree2(root+1,left,rootIndex-1, preOrder, inOrder);
        treeRoot.right = buildTree2(root+rootIndex-left+1,rootIndex+1,right,preOrder,inOrder);
        return treeRoot;
    }

}

* */