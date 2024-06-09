package leecode.link;

public class Lee19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1, head);

        int size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }

        ListNode prev = dummy;
        for (int i = 1; i <= size - n; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
