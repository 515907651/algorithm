package topinterview;

import List.ListNode;

public class _2_AddTwoNumbers_Meidium {
    // 还是蛮好想的，因为它是个逆序排列的，也就是低位在前
    // 同时遍历两链表，选择其中一个作为结果链表，节省空间，或者新建一个链表，新建简单一点感觉。
    // 对于相加的结果，设置一个变量flag，falg表示是否进位，默认为不进，当是进位的时候，当前运算结果+1
    // 存在一个链表节点为空或者都为空的情况，如果一个为空，那么直接将另一个加上进位就OK，两个为空，判断是否进位，进位就新建一个节点，变成1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode prev = head;
        int flag = 0;
        while (l1 != null || l2 != null) {
            // 连接上前面的节点
            ListNode cur = new ListNode();
            prev.next = cur;
            prev = prev.next;
            // 给cur赋值
            if (l1 != null && l2 != null) {
                // l1和l2不为null的情况
                int sum = l1.val + l2.val + flag;
                if (sum > 9) {
                    flag = 1;
                    cur.val = sum - 10;
                } else {
                    flag = 0;
                    cur.val = sum;
                }
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }
            if (l1 == null && l2 != null) {
                // l1是null但是l2不是null的情况
                int sum = l2.val + flag;
                if (sum > 9) {
                    flag = 1;
                    cur.val = 0;
                } else {
                    flag = 0;
                    cur.val = sum;
                }
                l2 = l2.next;
                continue;
            }
            if (l2 == null && l1 != null) {
                // l1是null但是l2不是null的情况
                int sum = l1.val + flag;
                if (sum > 9) {
                    flag = 1;
                    cur.val = 0;
                } else {
                    flag = 0;
                    cur.val = sum;
                }
                l1 = l1.next;
            }
        }
        if (flag != 0) {
            // 还有进位
            ListNode cur = new ListNode();
            prev.next = cur;
            prev = prev.next;
            cur.val = flag;
        }
        return head.next;
    }

}
