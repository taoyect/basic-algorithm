package leecode.link;

public class Lee2487 {
    /**
     * 从右往左找非递减序列
     *
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 为链表的长度。
     * 空间复杂度：O(n)，需要 O(n)的栈空间。
     * 递归本质就是在倒着遍历链表
     */
    public ListNode removeNodes(ListNode head) {
        if(head == null) return null;
        if(head.next == null) {
            return head;
        }
        ListNode subHead = removeNodes(head.next);
        if(head.val < subHead.val) {
            return subHead;
        }
        head.next = subHead;
        return head;
    }

    public ListNode removeNodes_E(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = dummy;
        while(prev.next != null) {
            ListNode cur = prev.next;
            boolean curDel = false;
            ListNode search = cur.next;
            while(search != null) {
                if(search.val > cur.val) {
                    curDel = true;
                    break;
                }
                search = search.next;
            }
            if(curDel) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {5,2,13,3,8};
        ListNode case1List = new ListNode(case1);
        ListNode listNode = new Lee2487().removeNodes(case1List);
    }
}
