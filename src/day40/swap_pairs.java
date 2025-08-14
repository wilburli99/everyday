package day40;

public class swap_pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode a = cur.next;
            ListNode b = a.next;
            // 开始交换：重新链接指针
            a.next = b.next;
            b.next = a;
            cur.next = b;
            // 跳到下一对
            cur = a;
        }
        return dummy.next;
    }
}
