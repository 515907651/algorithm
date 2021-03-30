package offer;

import java.util.List;

public class GetIntersectionNode_51_easy {
    // 看到这种相遇的题，想到了双指针，但是具体怎么个双指针法不晓得
    // 评论给了一种跑两次的双指针，正好解决了两个链表长度不同的问题
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;
        while (pointB != pointA) {
            pointA = (pointA == null) ? headB : pointA.next;
            pointB = (pointB == null) ? headA : pointB.next;
        }
        return pointA;
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
