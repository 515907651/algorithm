package topinterview;

import List.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _23_MergeKLists_Hard {
    /**
     * 合并k个链表
     * 优先队列和分治法想不到，写出来试试*/
    public ListNode mergeKLists1(ListNode[] lists) {

        ListNode head = new ListNode();
        ListNode dummyHead = head;
        if (lists == null || lists.length == 0 || lists[0] == null) {
            return null;
        }
        int n = lists.length;
        while (true) {
            ListNode min = new ListNode(Integer.MAX_VALUE);
            int flag = 0;
            for (int i = 0; i < n; i++) {
                if (lists[i] != null && lists[i].val < min.val) {
                    min = lists[i];
                    flag = i;
                }
            }
            if (min.val == Integer.MAX_VALUE) {
                break;
            }
            lists[flag] = lists[flag].next;
            head.next = min;
            head = head.next;
        }
        return head;
    }
/**
 * 优先队列，正好复习一下compare
 * */
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode dummyHead = head;
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode listNode : lists) {
            while (listNode != null) {
                queue.add(listNode);
                listNode = listNode.next;
            }
        }
        while (!queue.isEmpty()) {
            ListNode temp = new ListNode(queue.poll().val);
            head.next = temp;
            head = head.next;
        }
        return dummyHead.next;
    }
    }
