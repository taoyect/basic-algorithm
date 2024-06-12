package leecode.link;

/**
 * @author ct
 * @date 2024-06-11 11:15
 *
 * 归并merge 链表版本
 */
public class LE21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        while(list1 != null || list2 != null) {
            ListNode cur = null;
            if(list1 == null) {
                cur = new ListNode(list2.val);
                list2 = list2.next;
            } else if(list2 == null) {
                cur = new ListNode(list1.val);
                list1 = list1.next;
            } else if(list1.val <= list2.val) {
                cur = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur = new ListNode(list2.val);
                list2 = list2.next;
            }
            prev.next = cur;
            prev = prev.next;
        }
        return dummy.next;
    }
}
