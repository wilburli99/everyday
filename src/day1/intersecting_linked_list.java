package day1;

import java.util.HashSet;
import java.util.Set;

public class intersecting_linked_list {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        // 创建哈希集合
        Set<ListNode> viseted = new HashSet<ListNode>();
        // 创建临时节点
        ListNode tmp = headA;
        // 遍历链表A，将节点加入集合
        while (tmp != null) {
            viseted.add(tmp);
            tmp = tmp.next;
        }
        // 遍历链表B，判断节点是否在集合中
        tmp = headB;
        while (tmp != null) {
            if (viseted.contains(tmp)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
}
