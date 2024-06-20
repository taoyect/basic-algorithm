package leecode.link;

public class LM_92_reverse {

    /**
     *
     * 定义两个指针，分别称之为 g(guard 守卫) 和 p(point)
     * 1. 将 g 移动到第一个要反转的节点的前面，将 p 移动到第一个要反转的节点的位置上
     * 2. 将 p 后面的元素删除，然后添加到 g 的后面。也即头插法
     * 注意：left和right的取值，e.g.当left为第一个节点head时，left=1
     */
    public ListNode reverse(ListNode head, int left, int right) {
       ListNode dmy = new ListNode(-1, head);
       ListNode g = dmy;

        for (int i = 1; i < left; i++) { //i < left，循环结束后，g指向left前一个节点
            g = g.next; //当i=1时，计算完毕后, g指向第1个节点
        }
        ListNode p = g.next;

        for (int i = 0; i < right - left; i++) { // 头插法插入节点, 处理次数 = right-left
            ListNode remove = p.next;   //找到目标删除节点
            p.next = remove.next;       //先断左
            remove.next = g.next;       //后断右
            g.next = remove;            //最后插入
        }
        return dmy.next;
    }

    /**
     * 第一版思路：
     * 基于dummy节点和计数变量s(size)，走一遍循环：
     * 在s == left时，
     * 通过指针p1记住left前一个节点，等翻转完成后，通过p1来连接翻转后的头节点(节点4)；
     * 通过指针tmp记住left节点，等翻转完成后，tmp将成为翻转部分的尾节点，通过tmp来连接后续节点(节点5)；
     * 在s==right时，
     * 第1步，通过指针p2记住right后一个节点（可能为null），等翻转完成后，通过tmp.next = p2完成连接；
     * 第2步，断开right节点和其后一个节点的连接（这样从left到right的翻转可以直接使用翻转整个链表的代码）
     * 走完一遍循环后，调用reverse(p1.next), 并将翻转后的链表和未翻转部分连接即可。
     *
     */
    public ListNode reverse1(ListNode head, int left, int right) {
        ListNode dmy = new ListNode(-1, head);
        ListNode prev = dmy;
        int s = 0;
        ListNode p1 = null;
        ListNode tmp = null;
        ListNode p2 = null;
        while(prev.next != null) {
            s++;
            if(s == left) {
                p1 = prev;
                tmp = prev.next;
            }
            if(s == right) {
                p2 = prev.next.next;
                prev.next.next = null;  //断开右边
                break;
            }
            prev = prev.next;
        }
        p1.next = reverse(p1.next);
        tmp.next = p2;
        return dmy.next;
    }
    private ListNode reverse(ListNode h) {
        ListNode prev = null;
        ListNode cur = h;
        while(cur != null) {
            ListNode nx = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nx;
        }
        return prev;
    }
}
