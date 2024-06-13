package leecode.link;

public class LM86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dmy1 = new ListNode(Integer.MIN_VALUE);
        ListNode little = dmy1;
        ListNode dmy2 = new ListNode(Integer.MIN_VALUE);
        ListNode big = dmy2;
        ListNode prev = new ListNode(Integer.MIN_VALUE, head);
        while(prev.next != null) {
            if(prev.next.val < x) {
                ListNode move = prev.next;
                prev.next = move.next;
                move.next = null;
                little.next = move;
                little = move;
            } else {
                ListNode move = prev.next;
                prev.next = move.next;
                move.next = null;
                big.next = move;
                big = move;
            }
        }
        little.next = dmy2.next;
        return dmy1.next;
    }
}
