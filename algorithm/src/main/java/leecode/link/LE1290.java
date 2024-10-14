package leecode.link;

public class LE1290 {
    public int getDecimalValue(ListNode head) {
        int size = 0;
        ListNode h = head;
        while (h != null) {
            size++;
            h = h.next;
        }
        int sum = 0;
        while (head != null) {
            double k = Math.pow(2, size - 1);
            sum += k * head.val;
            head = head.next;
            size--;
        }
        return sum;
    }
}
