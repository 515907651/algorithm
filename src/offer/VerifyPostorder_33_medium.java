package offer;

public class VerifyPostorder_33_medium {
    public boolean verifyPostorder(int[] postorder) {
        // 判断是否是二叉搜索树的后序遍历
        // 注意二叉搜索树左小右大，后序遍历左右中，最后一个是根节点
        // 先找到最后一个数字root，遍历数组，找到第一个大于root的值，其位置为pos
        // 那么pos之前为左子树，后面到root是右子树，递归
        // 返回条件有点难想
        // 如果右子树里有小于root的，返回false，因为之前找第一个大于root的值确定了左子树都小于root，但是这个root传入怎么搞
        // 先遍历一遍右子树吧，有小于root的直接返回false，没有就继续递归
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        return recur(postorder, 0, postorder.length-1);
    }
    public boolean recur(int[] postorder, int left, int right){
        // 对于左子树，不需要遍历判断大小，直接把最后一个作为root，递归
        // 对于右子树，先遍历判断大小，全都大于再递归
        if (left >= right) {
            return true;
        }
        int low = left;
        // int temp = postorder[right];
        while (postorder[low]<postorder[right]){
            // 如果没有大于它的怎么办
            // 好像没影响
            low++;
            // low是第一个大于根的节点，后面别忘了-1
        }
        for (int i = low; i < right; i++) {
            if (postorder[i]<postorder[right]){
                return false;
            }
        }
        return recur(postorder,left,low-1)&&recur(postorder,low,right-1);
    }

}
