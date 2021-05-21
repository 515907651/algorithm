package offer;

public class MergeTwoLists_25_easy {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 先建立一个头节点，然后依次往后面加l1和l2中比较小的那个，最后返回头节点的next
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return temp.next;
    }
    }
