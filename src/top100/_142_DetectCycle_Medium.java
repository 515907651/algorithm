package top100;

import List.ListNode;

public class _142_DetectCycle_Medium {
    // 还是快慢指针，不同的是要求返回环的第一个节点
    // 环的第一个节点就是相遇的第一个节点
    // 错了，应该快慢指针同时从开头走，当相遇时，再用一个ptr指针从开头走，直到和slow相遇

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode ptr = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
            if (slow == fast) {
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
