package leecode.link;

/**
 * @author ct
 * @date 2024-06-07 16:13
 */
public class LM2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;

            if(head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;

            if(l1 != null) {
                l1 = l1.next;
            }

            if(l2 != null) {
                l2 = l2.next;
            }
        }

        if(carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{9,9,9,9,9,9,9};
        int[] arr2 = new int[]{9,9,9,9};
        ListNode list1 = new ListNode(arr1);
        ListNode list2 = new ListNode(arr2);
        new LM2().addTwoNumbers(list1, list2);
    }
}
