package leecode.link;

public class LE876 {
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode h = head;
        while(h != null) {
            size++;
            h = h.next;
        }
        for (int i = 1; i <= (size / 2); i++) {
            head = head.next;
        }
        return head;
    }
}
