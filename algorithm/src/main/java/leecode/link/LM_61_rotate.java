package leecode.link;

public class LM_61_rotate {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        if(k == 0) return head;
        int size = 0;
        ListNode p = new ListNode(-1, head);
        while(p.next != null) {
            size++;
            p = p.next;
        }
        //跳出循环后, p为尾节点, 直接连接head形成环
        p.next = head;
        for (int i = 0; i < size - (k % size); i++) {
            p = p.next;
        }
        //for循环结束，p指向需要断开的位置
        ListNode newH = p.next;
        p.next = null;
        return newH;
    }
}
