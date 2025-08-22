package day43;

public class add_two_nums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0; // 进位
        ListNode head = null, tail = null;
        while(l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry; // 每一次的sum
            if (head == null) { // 处理第一个点
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10; // 看是否有进位
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 处理最后的进位
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
