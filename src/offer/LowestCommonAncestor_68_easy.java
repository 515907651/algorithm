package offer;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor_68_easy {
    // 找最近的公共祖先
    // 我的想法是，找出他们的所有祖先，再找出公共祖先，由近到远排序，第一个就是最近的公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 这是个二叉搜索树啊，就很简单了，两次遍历，一次找p的路径，一次找q的路径
        List<TreeNode> pathP = findPath(root, p);
        List<TreeNode> pathQ = findPath(root, q);
        // 然后找最近的相同节点
        // 思路是，从根节点出发，找到第一个不同的节点，那么这个节点的上一个节点就是最近的公共祖先节点
        TreeNode result = new TreeNode();
        for (int i = 0; i < pathP.size() && i <pathQ.size(); i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                result = pathP.get(i);
            } else {
                break;
            }
        }
        return result;
    }
    public List<TreeNode> findPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        while (root.val != target.val) {
            path.add(root);
            if (root.val > target.val) {
                // 去左子树
                root = root.left;
            } else {
                // 去右子树
                root = root.right;
            }
        }
        // 自己也是祖先节点
        path.add(root);
        return path;
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // 不用list存储路径，直接找
        TreeNode result = new TreeNode();
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                // 两节点的值都小于父节点
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                // 两节点的值都大于父节点
                root = root.right;
            } else {
                // 产生分叉，包括了相等的情况
                result = root;
                break;
            }
        }
        return result;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 递归法
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor2(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        return root;
    }
}
