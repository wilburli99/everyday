package day37;

public class sort_list_toBST {
//    // 链表->数组->转BST--复杂度高
//    public TreeNode sortedListToBST(ListNode head) {
//        ListNode tmp = head;
//        int size = 0;
//        while (tmp != null) {
//            tmp = tmp.next;
//            size++;
//        }
//        int[] nums = new int[size];
//        for (int i = 0; i < size; i++) {
//            if (head == null) return null;
//            nums[i] = head.val;
//            head = head.next;
//        }
//        return resTree(nums, 0, nums.length-1);
//    }
//
//    private TreeNode resTree(int[]nums, int inleft, int inright) {
//        if (inleft > inright) return null;
//        int mid = inleft + (inright - inleft) / 2;
//        TreeNode root = new TreeNode(nums[mid]);
//        root.left = resTree(nums, inleft, mid-1);
//        root.right = resTree(nums, mid+1, inright);
//        return root;
//    }

    // 不用将链表转为数组，直接用链表的快慢指针找mid
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return resTree(head, null);
    }
    private TreeNode resTree(ListNode head, ListNode tail) {
        if (head == tail) return null;
        // 快慢指针找mid
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow就是中点
        TreeNode root = new TreeNode(slow.val);
        root.left = resTree(head, slow);
        root.right = resTree(slow.next, tail);
        return root;
    }
}
