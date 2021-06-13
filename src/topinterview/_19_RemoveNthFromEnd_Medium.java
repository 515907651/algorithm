package topinterview;

import List.ListNode;

public class _19_RemoveNthFromEnd_Medium {
    // offer里做过吧，快慢指针找到倒数第n个节点，然后删除
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummyHead;
        while (n > 1 && fast.next != null) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }

}
