package leecode.link;

/**
 * @author ct
 * @date 2024-06-06 15:50
 */
public class Del203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        while(prev.next != null) {
            if(prev.next.val == val) {
                prev.next = prev.next.next;
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
      // 没有使用dummyHead
        while(head != null && head.val == val) {
            ListNode delHead = head;
            head = head.next;
            delHead.next = null;
        }

        if(head == null) return null;

        ListNode prev = head;
        while(prev.next != null) {
            if(prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements3(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements3(head.next, val);    //把removeElements3当作是一个有现成功能的函数即可
        return head.val == val ? head.next : head;
    }
    public ListNode removeElements4(ListNode head, int val, int depth) {
        String depthStr = generateDepthStr(depth);
        System.out.println(depthStr + "Call: remove " + val + " in " + head);


        if(head == null) {
            System.out.println(depthStr + "Return: null");
            return null;
        }
        ListNode result = removeElements4(head.next, val, depth + 1);
        System.out.println(depthStr + "After remove " + val + ": " + result);

        ListNode ret;
        if(head.val == val) {
            ret = result;
        } else {
            head.next = result;
            ret = head;
        }
        System.out.println(depthStr + "Return: " + ret);
        return ret;
    }

    private String generateDepthStr(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(arr);
        new Del203().removeElements4(listNode, 6, 0);
    }
}
