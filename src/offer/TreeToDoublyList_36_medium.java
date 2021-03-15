package offer;

public class TreeToDoublyList_36_medium {
    Node1 head;
    Node1 pre;
    public Node1 treeToDoublyList(Node1 root) {
        if (root == null) {
            return null;
        }
        // 一棵二叉搜索树，所以中序遍历
        // 我直接搞一个栈，按顺序把所有的节点入栈，然后出栈的时候确定前驱和后继
        // 直接在递归中实现就OK了
        dfs(root);
        head.left = pre;
        pre.right = head;
        return null;
    }
    public void dfs(Node1 node){
        if (node == null) {
            return;
        }
        // 怎么判断是头结点，头结点没有前驱
        dfs(node.left);
        if (pre == null){
            head = node;
        } else {
            pre.right = node;
            node.left = pre;
        }
        pre = node;
        dfs(node.right);
        // 怎么判断是尾结点，尾结点是最后的pre

    }

}
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val,Node1 _left,Node1 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
