public class SingleLinkedList {
    // 1、无头单向非循环链表实现
    public class singleLinkedList {
        // 定义节点
        private class ListNode {
            int val;
            ListNode next;
            ListNode(int val) {
                this.val = val;
                this.next = null;
            }
        }

        private ListNode head;
        //头插法
        public void addFirst(int data) {
            ListNode newNode = new ListNode(data);
            newNode.next = head;
            head = newNode;
        }

        //尾插法
        public void addLast(int data) {
            if (head == null) {
                addFirst(data);
                return; // 如果不return，则addLast会执行两遍
            }
            ListNode cur = head;
            while (cur.next != null) { // 如果是cur != null 则会报空指针异常
                cur = cur.next;
            }
            ListNode newNode = new ListNode(data);
            cur.next = newNode;
        }
        //任意位置插入,第一个数据节点为0号下标
        public boolean addIndex(int index,int data) {
            ListNode cur = head;
            if (index < 0 || index > size()) {
                return false;
            } else if (index == 0) {
                addFirst(data);
            } else if (index == size()) { // 判断 index == size() 时使用 addLast(data) 提升效率与可读性。
                addLast(data);
            } else {
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
                ListNode newNode = new ListNode(data);
                newNode.next = cur.next;
                cur.next = newNode;
            }
            return true;
        }
        //查找是否包含关键字key是否在单链表当中
        public boolean contains(int key) {
            ListNode cur = head;
            while (cur != null) {
                if (cur.val == key) {
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }
        //删除第一次出现关键字为key的节点
        public void remove(int key) {
            // 要处理头节点为null 和 key的情况
            if (head == null) {
                return;
            }
            if (head.val == key) {
                head = head.next;
                return;
            }
            ListNode cur = head;
            while (cur.next != null) { // cur.next 可能为空，cur.next.val 会抛空指针异常。所以这里不能是cur != null
                if (cur.next.val == key) {
                    cur.next = cur.next.next;
                    return;
                }
                cur = cur.next;
            }
        }
        //删除所有值为key的节点
        public void removeAllKey(int key) {
            // 处理head本身为key的情况
            while (head != null && head.val == key) {
                head = head.next;
            }
            ListNode cur = head;
            while (cur != null && cur.next != null) { // cur.next 可能为空，cur.next.val 会抛空指针异常
                if (cur.next.val == key) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
        }
        //得到单链表的长度
        public int size() {
            ListNode cur = head;
            int count = 0;
            while (cur != null) {
                count++;
                cur = cur.next;
            }
            return count;
        }
        public void display() {
            ListNode cur = head; // 不能直接更新head，会破坏链表结构
            while (cur != null) {
                System.out.print(cur.val + " ");
                cur = cur.next; // 一定要更新cur，否则会进入死循环
            }
            System.out.println();
        }
        public void clear() {
            head = null;
        }
    }
}
