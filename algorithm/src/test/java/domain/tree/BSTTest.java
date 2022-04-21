package domain.tree;

import org.junit.Test;

import java.util.Arrays;

public class BSTTest {

    /**
     *          5
     *       3    6
     *     2  4    8
     */
    @Test
    public void testPreOrder() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        System.out.println(bst);
        bst.preOrder(); //5 3 2 4 6 8
    }
}
