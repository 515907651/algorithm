package offer;

import List.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseList_24_easy {
    public ListNode reverseList(ListNode head) {
        // 当头节点是空或者只有一个节点的时候，直接返回head
        if (head==null||head.next==null) return head;
        Deque<ListNode> listStack = new ArrayDeque<>();
        // 怎么个放法呢
        ListNode temp;
        while (head!=null){
            temp = head;
            listStack.push(head);
            head = head.next;
            temp.next = null;
        }
        head = listStack.pop();
        temp = head;
        while (!listStack.isEmpty()){
            head.next = listStack.pop();
            head = head.next;
        }
        return temp;
    }
    public ListNode reverseList1(ListNode head) {
        // 用双指针来做，空间复杂度降为1
        // 先写下具体过程，一个pre，一个current，一个after
        ListNode pre = null;
        ListNode current = head;
        ListNode after;
        while (current != null) {
            after = current.next;
            current.next = pre;
            pre = current;
            current = after;
        }
        return pre;
    }

    }
