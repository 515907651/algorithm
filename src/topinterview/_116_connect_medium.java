package topinterview;

import java.util.Deque;
import java.util.LinkedList;

public class _116_connect_medium {
    public Node connect(Node root) {
        // 简简单单层次遍历
        // 特殊情况判断
        if (root == null) {
            return root;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 要将同层节点连接起来
                // 对于首个节点，没有
                // 对于最后一个节点，next = null
                Node current = queue.pop();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                if (i != size - 1) {
                    current.next = queue.peek();
                } else {
                    current.next = null;
                }
            }
        }
        return root;
    }

}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
