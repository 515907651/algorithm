package List;
/*
* 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
* */
public class MergeTwoLists_21_easy {
    public static void main(String[] args) {

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 思路
        // 首先要判断什么时候插入节点
        // 把l1作为最终结果，那么将l2的节点插入l1
        // 三种情况：1.当相等时，直接插入 2.当小于时，插入到前面 3.当大于当前时，再判断后面的一个
        // 最终有几种情况
        // 1. 正好完全插入 2. l1有剩余，这个就不用管了 3. l2有剩余，剩下的插入到最后
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = new ListNode();
        ListNode now = result;
        while (l1 != null && l2 != null) {
            // 如果有一个一开始就是null咋整，还是搞个特殊情况判断吧
            // 最终谁作为返回list，整个新的链表头吧，谁小谁往里插
            if (l1.val <= l2.val) {
                ListNode temp = l1.next;
                l1.next = null;
                result.next = l1;
                l1 = temp;
            } else {
                ListNode temp = l2.next;
                l2.next = null;
                result.next = l2;
                l2 = temp;
            }
            result = result.next;
        }
        if (l1 == null) result.next = l2;
        if (l2 == null) result.next = l1;
        return now.next;
    }

    private static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 官方题解，那是真的简洁，我的又臭又长，思路是一样的
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;

    }
}
