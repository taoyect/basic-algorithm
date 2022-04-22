package domain.tree;

import org.junit.Test;

import java.util.Arrays;

public class BSTTest {

    /**
     *          5
     *       3    7
     *     2  4  6  8
     */
    @Test
    public void testPreOrder() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        System.out.println(bst);
        bst.preOrder(); //5 3 2 4 7 6 8
    }
    @Test
    public void testPreOrderNR() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        System.out.println(bst);
        bst.preOrderNR(); //5 3 2 4 7 6 8
    }
    /**
     *          5
     *       3    7
     *     2  4  6  8
     */
    @Test
    public void testInOrder() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        bst.inOrder(); //2 3 4 5 6 7 8
    }
    @Test
    public void testInOrderNR() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        bst.inOrderNR(); //2 3 4 5 6 7 8
    }
    /**
     *          5
     *       3    7
     *     2  4  6  8
     */
    @Test
    public void testPostOrder() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        bst.postOrder(); //2 4 3 6 8 7 5
    }
}
