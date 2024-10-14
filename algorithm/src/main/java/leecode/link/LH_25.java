package leecode.link;

public class LH_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode idx = head;
        for (int i = 0; i < k; i++) {
            if(idx == null) return head; //剩余数量小于k，无需反转，直接返回
            idx = idx.next;
        }

        // =============【翻转前k个链表】=================
        ListNode prev = null;
        ListNode cur = head;
        while(cur != idx) { //idx指向的刚好是第k个节点的下一个节点
            ListNode nx = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nx;
        }
        // ==============================================

        head.next = reverseKGroup(cur, k);
        return prev;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode listNode = new ListNode(arr);
        ListNode listNode1 = new LH_25().reverseKGroup(listNode, 3);
        System.out.println(listNode1);
    }

}
