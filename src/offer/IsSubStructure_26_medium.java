package offer;

import DataStructure.TreeNode;

public class IsSubStructure_26_medium {
    // 对于A树，比较当前节点是否和B树是子结构关系，不是就比较左节点，再不是就比较右节点
    // 比较的时候，如果B为空，说明b树遍历完，返回true；如果A为空或者A的值和B不相同，说明不是子结构，继续比较A的左节点和B的左节点，A的右节点和B的右节点
    public boolean isSubStructure(TreeNode A, TreeNode B) {
/*
        if (A == null || B == null) return false;
        return recur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
*/
          return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B==null) return true;
        if (A==null||A.val != B.val) return false;
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }
}