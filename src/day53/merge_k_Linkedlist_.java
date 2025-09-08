package day53;

import java.util.PriorityQueue;

public class merge_k_Linkedlist_ {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        // 先用最小堆存放头节点，按照节点从小到大，用比较器比较
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a,b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll(); // 取出当前最小节点
            tail.next = cur; // 接入最终链表
            tail = cur;
            if (cur.next != null) pq.offer(cur.next); // 放入当前点的后继
        }
        return dummy.next;
    }
}
