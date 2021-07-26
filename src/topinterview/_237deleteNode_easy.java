package topinterview;

import List.ListNode;

public class _237deleteNode_easy {
    public void deleteNode(ListNode node) {
        // 删除当前节点的一种思路，和脑筋急转弯似的
        // 把当前节点变成后面的一个节点，并且删除后面的那个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
