package topinterview;


import DataStructure.TreeNode;

public class _230_kthSmallest_medium {
    // 简简单单中序遍历，到第K个的时候就停止
    int num;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        // 判断特殊情况，先不判断
        ans = 0;
        num = k;
        mediumOrder(root);
        return ans;
    }
    private void mediumOrder(TreeNode root) {
        if (root == null || num <= 0) {
            return;
        }
        mediumOrder(root.left);
        num--;
        if (num == 0) {
            ans = root.val;
        }
        mediumOrder(root.right);
    }

}
