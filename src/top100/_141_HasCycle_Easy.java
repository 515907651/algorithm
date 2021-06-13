package top100;

import List.ListNode;

public class _141_HasCycle_Easy {
    // 双指针
    // 自己写的太丑了，而且逻辑不清晰
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public boolean hasCycle1(ListNode head) {
        // 因为fast走得快，所以直接判断fast就可以了，slow不用判断是否到结尾

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return false;
            }
        }
        return true;

    }

    }
