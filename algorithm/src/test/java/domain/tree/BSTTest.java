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
        System.out.println(bst.levelOrder());
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
    /**
     *          5
     *       3    7
     *     2  4  6  8
     */
    @Test
    public void testLevelOrder() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        bst.levelOrder(); //5 3 7 2 4 6 8
    }
    @Test
    public void testMinimum() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        System.out.println(bst.minimum());
    }

    @Test
    public void testMaximum() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        System.out.println(bst.maximum());
    }
    @Test
    public void testRemoveMin() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        System.out.println(bst.removeMin());
        System.out.println(bst.removeMin());
        System.out.println(bst);
    }
    @Test
    public void testRemoveMax() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        System.out.println(bst.removeMax());
        System.out.println(bst.removeMax());
        System.out.println(bst);
    }
    @Test
    public void testRemoveMinNR() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        System.out.println(bst);
        bst.preOrder(); //5 3 2 4 7 6 8
        System.out.println(bst.removeMinNR(bst.getRoot()));
        System.out.println(bst);
        bst.preOrder(); //5 3 4 7 6 8

    }
    @Test
    public void testRemove() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        System.out.println(bst);
        bst.preOrder(); //5 3 2 4 7 6 8
        System.out.println(bst.remove(bst.getRoot(), 7));
        System.out.println(bst);
        bst.preOrder(); //5 3 2 4 8 6

    }
}
