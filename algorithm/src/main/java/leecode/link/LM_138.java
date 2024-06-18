package leecode.link;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ct
 * @date 2024-06-18 17:27
 */
public class LM_138 {
    Map<Node, Node> map = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(!map.containsKey(head)) {
            Node h = new Node(head.val);
            map.putIfAbsent(head, h);
            h.next = copyRandomList(head.next);
            h.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}
