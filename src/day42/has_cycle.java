package day42;

public class has_cycle {
    public boolean hasCycle(ListNode head) {
        // Set<ListNode> visited = new HashSet<ListNode>();
        // //哈希表遍历链表，如果找到相同的节点就证明有环
        // ListNode cur = head;
        // while (cur != null) {
        //     if (!visited.add(cur)) {
        //         return true;
        //     }
        //     cur = cur.next;
        // }
        // return false;

        // 快慢指针（Floyd 判圈算法）
        // 定义两个指针：slow 每次走一步，fast 每次走两步。
        // 如果链表有环，fast 总会在环内追上 slow。
        // 如果链表无环，fast 会走到 null。
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
