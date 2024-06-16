package leecode.link;

public class LE_206 {
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode subH = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return subH;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode nx = head.next;
        head.next = null;
        ListNode subH = reverseList2(nx);
        nx.next = head;
        return subH;
    }

    /**
     * 迭代版
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode nx = cur.next;
            cur.next = prev;    //翻转
            prev = cur;         //移动prev指针到cur
            cur = nx;           //移动cur指针到nx
        }
        return prev;
    }
}
