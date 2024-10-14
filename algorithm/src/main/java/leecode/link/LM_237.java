package leecode.link;

public class LM_237 {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        ListNode nx = node.next;
        node.val = nx.val;
        node.next = nx.next;
        nx.next = null;
    }
}
