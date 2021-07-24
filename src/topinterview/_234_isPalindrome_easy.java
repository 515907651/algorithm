package topinterview;

import List.ListNode;

public class _234_isPalindrome_easy {
    public boolean isPalindrome(ListNode head) {
        // 首先快慢指针找到中点，一直觉得快慢指针使用来判断环，还能找中点
        // 快指针走两步，慢指针走一步，当快指针走到结尾的时候，慢指针走到中间
        // 如果节点数量是奇数，那么正好在中间，偶数呢？
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 这次快慢指针，找的不是中点，如果是奇数，是中点，如果是偶数，是前一半的最后一个
        // 然后反转后半部分链表
        ListNode start = slow.next;
        ListNode pre = null;
        ListNode cur = start;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 此时pre就是反转后的头结点
        // 判断pre和head是否相同
        while (pre != null) {
            // 这里的条件不能是判断head为空，而是pre，pre有可能一开始就是空的，比如2个节点的时候
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

}
