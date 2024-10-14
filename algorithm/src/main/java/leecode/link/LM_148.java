package leecode.link;

public class LM_148 {
    public ListNode sortList(ListNode head) {
      return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        // 如果链表为空或只有一个节点，无需排序直接返回
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = mid(head);            // 获取链表的中间节点，分别对左右子链表进行排序
        ListNode right = mergeSort(mid.next);   // 排序右子链表
        mid.next = null;                        // 断开两段子链表
        ListNode left = mergeSort(head);        // 排序左子链表
        return merge(left, right);              // 两个子链表必然有序，合并两个有序的链表
    }

    private ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(true) {
            if(fast == null || fast.next == null) return slow;
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dmy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dmy;
        while(left != null || right != null) {
            int n1 = left == null ? Integer.MAX_VALUE : left.val;
            int n2 = right == null ? Integer.MAX_VALUE : right.val;
            if(n1 < n2) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        return dmy.next;
    }

}
