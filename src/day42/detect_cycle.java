package day42;

public class detect_cycle {
    public ListNode detectCycle(ListNode head) {
        // 快慢指针
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        // 2(a + b) ≡ a + b  (mod L)
        // ⇒ a + b ≡ 0 (mod L)
        // ⇒ a ≡ −b ≡ L − b ≡ c (mod L)
        // a = c（模 L 意义下）
        ListNode p1 = head, p2 = slow;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
