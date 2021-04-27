package offer;

import DataStructure.TreeNode;

public class LowestCommonAncestor_68_2_medium {
    private TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 这个题就是加强版的68题，这次是普通二叉树了
        // 最近公共祖先节点的条件应该是
        // (节点的左边和右边都有p，q) || 节点本身是p || 节点本身是q && 节点的左边或者右边包含p或者q
        // 要用到递归，妈的，递归就整不明白
        result = new TreeNode();
        dfs(root, p, q);
        return result;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            // 当节点是null的时候，肯定不是祖先节点
            return false;
        }
        boolean lson = dfs(root.left, p , q);
        boolean rson = dfs(root.right, p, q);
        if (lson && rson || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            result = root;
        }
        // 返回当前节点是否包含p或者q
        return lson || rson || root.val == p.val || root.val == q.val;
    }


}
