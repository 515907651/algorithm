package offer;



public class CopyRandomList_35_medium {
    public Node copyRandomList(Node head) {
        // 题目是要实现链表的深拷贝
        // 先复制链表，然后再按random指向复制的链表，最后拆分
        if (head == null){
            return null;
        }
        Node temp = head;
        // 复制
        while (temp != null){
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            // 不需要考虑temp.next == null，因为是node
            temp = temp.next.next;
        }
        temp = head;
        // 链接random
        while (temp != null){
            if (temp.random != null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        // 拆分
        Node ans = head.next;
        Node result = head.next;
        temp = head;
        while(temp!=null){
            // 要考虑null节点
            temp.next = temp.next.next;
            if(result.next != null){
                result.next = result.next.next;
            }
            temp = temp.next;
            result = result.next;
        }
        return ans;
    }

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
