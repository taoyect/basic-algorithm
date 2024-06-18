package leecode.link;

public class LM_61_rotate {
    /**
     * 1. 特殊情况先处理
     * if(head == null || head.next == null) return head;
     * if(k == 0) return head;
     * 2. 2. 找到尾节点(指针p)，算出size，尾连头构建环; p继续往前走（size - k%size）步, 定位新的头节点，接着断开链表即可。
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        if(k == 0) return head;
        int size = 0;
        ListNode p = new ListNode(-1, head);
        while(p.next != null) {
            size++;
            p = p.next;
        }
        p.next = head;   //跳出循环后, p为尾节点, 直接连接head形成环
        for (int i = 0; i < size - k % size; i++) {   //p继续往前走（size - k%size）步
            p = p.next;
        }
        ListNode newH = p.next; //定位到新的头节点
        p.next = null;  //断开环
        return newH;
    }
}
