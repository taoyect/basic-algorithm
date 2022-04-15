package sort;

/**
 * 合并K个升序链表
 */
public class NLinkSort {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort(ListNode[] arr, int lo, int hi) {
        if (lo >= hi) return arr[lo]; //递归树的叶子节点为一个个的ListNode
        int mid = (lo + hi) / 2;
        ListNode listNode1 = sort(arr, lo, mid);
        ListNode listNode2 = sort(arr, mid + 1, hi);
        return merge(listNode1, listNode2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode list = new ListNode(-1);
        ListNode temp1 = new ListNode(-1);
        ListNode temp2 = new ListNode(-1);
        ListNode temp3 = new ListNode(-1);
        temp1.next = l1;
        temp2.next = l2;
        temp3.next = list;
        while(temp1.next != null || temp2.next != null) {
            if (temp1.next == null) {
                temp3.next.next = temp2.next;
                temp3.next = temp3.next.next;
                temp2.next = temp2.next.next;
            } else if(temp2.next == null) {
                temp3.next.next = temp1.next;
                temp3.next = temp3.next.next;
                temp1.next = temp1.next.next;
            } else if(temp1.next.val < temp2.next.val) {
                temp3.next.next = temp1.next;
                temp3.next = temp3.next.next;
                temp1.next = temp1.next.next;
            } else {
                temp3.next.next = temp2.next;
                temp3.next = temp3.next.next;
                temp2.next = temp2.next.next;
            }
        }
        return list.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

