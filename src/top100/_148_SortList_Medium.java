package top100;

import List.ListNode;

public class _148_SortList_Medium {
    // 归并排序啊，又忘记了，其实涉及到递归的我几乎都记不住
    // 这个对链表进行归并排序还是比较麻烦的
    // 这个找链表中点的方法太骚了，快慢指针，当快指针走到终点的时候，慢指针正好在中间
    // 先找中点，对中点分割的前后链表进行排序，然后合并两链表
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            // 这里理解不好
            // == null的话不通过
            head.next = null;
            return head;
        }
        // 找到中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            // 这里判断条件不能是null，应该是尾结点
            // 结束了slow指向的是中间节点和哪个节点呢
            // 这里理解不好
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode left = sortList(head, mid);
        ListNode right = sortList(mid, tail);
        //ListNode right = sortList(mid.next, tail);
        // 这样重合了一个mid啊，感觉应该是mid.next作为头节点
        // 只有mid才能通过，理解不好
        // 将排序后的左右链表归并
        ListNode sorted = merge(left,right);
        return sorted;
    }

    private ListNode sortList1(ListNode head) {
        // 具体步骤是
        // 初始化sublength为1，然后将长度为sublength的子链表合并，sublength*2，当sublength大于等于length的时候，结束
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            // 求出总长度
            temp = temp.next;
            length++;
        }
        // 建立一个头结点
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            // 思想就是每次遍历链表，把subLength合并
            ListNode cur = dummyHead.next;
            ListNode prev = dummyHead;
            while (cur != null) {
                ListNode list1 = cur;
                for (int i = 1; cur.next != null && i < subLength; i++) {
                    cur = cur.next;
                }
                ListNode list2 = cur.next;
                // 断开
                cur.next = null;
                cur = list2;
                for (int i = 1; cur != null && cur.next != null && i < subLength; i++) {
                    cur = cur.next;
                }
                // 断开
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                ListNode sorted = merge(list1, list2);
                // 接到头结点后面
                prev.next = sorted;
                while (prev.next != null) {
                    prev = prev.next;
                }
                cur = next;
            }
        }
        return dummyHead.next;
    }
        private ListNode merge(ListNode left, ListNode right) {
        // 将两个链表排序嘛，这个简单
        ListNode head = new ListNode();
        ListNode temp = head;
        while (left !=null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                head = head.next;
                left = left.next;
            } else {
                head.next = right;
                head = head.next;
                right = right.next;
            }
        }
        if (left == null) {
            head.next = right;
        } else {
            head.next = left;
        }
        return temp.next;
    }

}
