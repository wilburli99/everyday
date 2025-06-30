package day5;

import java.util.ArrayList;
import java.util.List;

public class reverse_linkedlist {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> stack = new ArrayList<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }

        for (int i = stack.size() - 1; i > 0; i--) {
            stack.get(i).next = stack.get(i - 1);
        }
        stack.get(0).next = null;
        return stack.get(stack.size() - 1);
    }
}
