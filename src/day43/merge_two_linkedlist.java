package day43;

public class merge_two_linkedlist {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;
        ListNode l1 = list1, l2 = list2;
        while(l1 != null && l2 != null){
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        // 合并二者中剩余的部分
        if (l1 == null) {
            pre.next = l2;
        } else {
            pre.next = l1;
        }
        return prehead.next;
    }
}
