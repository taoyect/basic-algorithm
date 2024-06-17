package leecode.link;

public class LM_92_reverse {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dmy = new ListNode(-1, head);
        ListNode prev = dmy;
        int s = 0;
        ListNode p1 = null;
        ListNode p2 = null;
        while(prev.next != null) {
            s++;
            if(s == left) {
                p1 = prev;
            }
            if(s == right) {
                p2 = prev.next.next;
                prev.next.next = null;  //断开右边
                break;
            }
            prev = prev.next;
        }
        ListNode tmp = p1.next;
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
