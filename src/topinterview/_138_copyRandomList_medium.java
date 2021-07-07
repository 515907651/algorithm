package topinterview;

public class _138_copyRandomList_medium {
    // 剑指offer原题
    // 思路是三步走，第一步复制新节点，第二步指向随机指针，第三步是分开两个链表
    // 虽然写过，但是还是错了几个地方，主要是里面经常用到next.next，需要先判断next不为null
    public Node copyRandomList(Node head) {
        // 首先判断特殊情况
        if (head == null) {
            return head;
        }
        // 复制节点
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }
        // 指向随机指针
        Node pre = head;
        temp = head.next;
        while (temp != null) {
            if (pre.random != null) {
                temp.random = pre.random.next;
            }
            if (temp.next != null) {
                temp = temp.next.next;
                pre = pre.next.next;
            } else {
                break;
            }
        }
        // 分开两个链表
        temp = head.next;
        Node result = head.next;
        pre = head;
        while (result != null) {
            pre.next = pre.next.next;
            if (result.next != null) {
                result.next = result.next.next;
            }
            pre = pre.next;
            result = result.next;
        }
        return temp;
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


}

