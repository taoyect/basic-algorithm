package leecode.link;

public class LE_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dmy = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = dmy;
        while(prev.next != null) {
            if(prev.val == prev.next.val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dmy.next;
    }
}
