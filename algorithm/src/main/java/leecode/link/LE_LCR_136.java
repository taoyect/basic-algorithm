package leecode.link;

public class LE_LCR_136 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dmy = new ListNode(-1);
        dmy.next = head;
        ListNode prev = dmy;
        while(prev.next != null) {
            if(prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                break;
            }
            prev = prev.next;
        }
        return dmy.next;
    }
}
