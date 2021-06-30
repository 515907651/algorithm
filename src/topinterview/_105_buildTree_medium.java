package topinterview;

import DataStructure.TreeNode;

public class _105_buildTree_medium {
    // 之前写过，看看能不能再背出来
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 这里应该传入n-1还是n
        // 这里是-1，因为这个位置要取到的
        return recur(preorder, inorder, 0, 0, preorder.length - 1);
    }

    private TreeNode recur(int[] preorder, int[] inorder, int root, int left, int right) {
        if (left > right) {
            // 这里是大于等于么
            return null;
        }
        TreeNode newRoot = new TreeNode(preorder[root]);
        // 寻找index
        // 范围应该是从left到right
        int index = 0;
        for (int i = left; i <= right; i++) {
            if (inorder[i] == preorder[root]) {
                index = i;
                break;
            }
        }
        newRoot.left = recur(preorder, inorder, root + 1, left, index - 1);
        newRoot.right = recur(preorder, inorder, root + index - left + 1, index + 1, right);
        return newRoot;
    }

}
