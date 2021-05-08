package offer;

public class DeleteNode_18_easy {
    public ListNode deleteNode(ListNode head, int val) {
        // 删除给定的节点
        // 首先判断头结点
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
                return head;
            } else {
                current = current.next;
                pre = pre.next;
            }
        }
        return head;
    }
    }
