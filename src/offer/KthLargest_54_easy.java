package offer;

import DataStructure.TreeNode;

import java.util.ArrayList;

public class KthLargest_54_easy {
    // 我自己想到的思路是把所有的节点遍历一遍，将数字加入数组，然后找出第k大的值，O(n)的复杂度
    // 中序遍历出来的二叉搜索树就是有序的，找倒数第二个就OK了
    // 评论区老哥给了一个妙一点的方法，一样是中序，不过是先遍历右子树，第k个就可以返回了
    // 递归有返回值的时候迷糊的很，其实递归就迷糊的不行

    ArrayList<Integer> list;
    int count;
    int result;
    public int kthLargest1(TreeNode root, int k) {
        // 按照普通方法来一遍
        if (root == null) {
            return -1;
        }
        list = new ArrayList<>();
        midlle(root);
        return list.get(list.size() - k - 1);
    }

    private void midlle(TreeNode root) {
        if(root == null) {
            return;
        }
        midlle(root.left);
        list.add(root.val);
        midlle(root.right);
    }
    public int kthLargest2(TreeNode root, int k) {
        // 直接先右后左
        if (root == null) {
            return -1;
        }
        count = k;
        midlleRight(root);
        return result;
    }

    private void midlleRight(TreeNode root) {
        if (root == null) {
            return;
        }
        midlleRight(root.right);
        if (--count == 0) {
            result = root.val;
            return;
        }
        midlleRight(root.left);
    }
}
