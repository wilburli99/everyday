package day41;

public class partition_linkedlist {
    public ListNode partition(ListNode head, int x) {
        // 创建大小两个链表，small存放小于x的元素；large存放大于x的元素
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode small = smallDummy, large = largeDummy;
        // 新建一个指针指向头节点
        ListNode cur = head;
        while (cur != null) {
            // 先存下一个节点，断开旧链接
            ListNode next = cur.next;
            cur.next = null;
            // 如果当前值小于x，存入small链表
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                large.next = cur;
                large = large.next;
            }
            cur = next;
        }
        // 把两个链表拼接起来，小链表在前
        small.next = largeDummy.next;
        return smallDummy.next;
    }
}
