package leecode.link;

/**
 * @author ct
 * @date 2024-06-20 18:57
 */
public class LM_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dmy = new ListNode(-1, head);
        ListNode prev = dmy;

        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            ListNode mov = p2;
            p1.next = mov.next;
            prev.next = mov;
            prev = prev.next;
            if(p1.next == null) break;
            p1 = p1.next;
            p2 = p2.next.next;
            mov.next = null;
        }
        p1.next = dmy.next;
        return head;
    }
}
