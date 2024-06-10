package leecode.link;

public class Lee82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = dummy;
        while(prev.next != null) {
            ListNode cur = prev.next;
            boolean curDel = false;
            while(cur.next != null) {
                if(cur.val == cur.next.val) {
                   curDel = true;
                   cur.next = cur.next.next;
                } else {
                    break;
                }
            }
            if(curDel) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
