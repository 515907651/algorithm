package topinterview;

import DataStructure.TreeNode;

public class _108_sortedArrayToBST_easy {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 思路蛮简单的，找到中间节点作为根节点，左边为左子树，右边为右子树
        return recur(nums, 0, nums.length - 1);

    }

    private TreeNode recur(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recur(nums, left, mid - 1);
        root.right = recur(nums, mid + 1, right);
        return root;
    }

}
