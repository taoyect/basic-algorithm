package leecode.link;

public class Lee237 {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null;
    }
}
