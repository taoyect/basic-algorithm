package leecode.link;

/**
 * @author ct
 * @date 2024-06-06 15:36
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr cannot be empty!");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while(cur != null) {
            res.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        return res.append("NULL").toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
    }
}
