package offer;

import List.ListNode;

public class GetKthFromEnd_22_easy {
    // 找到链表倒数第k个节点，返回之后的链表
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int num = k;
        while(num>1&&fast.next!=null){
            // k到1走了k - 1步
            fast = fast.next;
            num--;
        }
        while (fast.next!=null){
            // fast走到最后一个节点时，slow距离fast k - 1步，也就是在倒数第k个节点上
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
