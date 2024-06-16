package leecode.link;

public class LE_876 {
    public ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if(fast == null || fast.next == null) return slow;
            slow = slow.next;
            fast = fast.next.next;
        }
    }
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (true) {
            if(fast == null) return slow;
            if(fast.next == null) return slow.next;
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    public ListNode middleNode1(ListNode head) {
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
