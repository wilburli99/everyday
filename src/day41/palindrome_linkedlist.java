package day41;

public class palindrome_linkedlist {
    public boolean isPalindrome(ListNode head) {
        // 快慢指针找中点，当fast走完的时候，slow就是中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 劈成两半，并反转后一半
        // 如果fast==null证明是偶数长度，从slow开始反转，因为slow = slow.next
        // 如果fast!=null证明是奇数长度，从slow.next开始反转，相当于跳过中间节点
        ListNode halfLinkedList = (fast == null) ? reserve(slow) : reserve(slow.next);
        // 比较
        ListNode p1 = head, p2 = halfLinkedList;
        boolean ok = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                ok = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return ok;
    }
    // 反转链表
    private ListNode reserve(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
