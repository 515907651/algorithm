package offer;

import List.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseList_24_easy {
    public ListNode reverseList(ListNode head) {
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

}
