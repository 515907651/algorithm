package topinterview;

import List.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class _206_reverseList_easy {
    // 简简单单反转链表，用个栈就ok
    // 思路有些地方不清醒
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Deque<ListNode> stack = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            // 想着把所有的点的后继都置为null，其实没必要，在再次形成链表的时候，只有头结点的next需要再次更改
            ListNode cur = temp;
            stack.push(temp);
            temp = temp.next;
            cur.next = null;
        }
        temp = stack.pop();
        ListNode cur = temp;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        return cur;
    }
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Deque<ListNode> stack = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = stack.pop();
        ListNode cur = temp;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return cur;
    }

    public ListNode reverseList2(ListNode head) {
        // 题解用了双指针
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}
