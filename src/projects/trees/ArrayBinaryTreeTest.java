package projects.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ArrayBinaryTreeTest {

    ArrayBinaryTree<Integer> emptyTree;
    ArrayBinaryTree<Integer> exampleTree;

    @BeforeEach
    void init() {
        emptyTree = new ArrayBinaryTree<>();

        exampleTree = new ArrayBinaryTree<>();
        exampleTree.addRoot(0);
        exampleTree.addLeft(exampleTree.root(), 1);
        exampleTree.addRight(exampleTree.root(), 2);
    }

    @Test
    void whenRootFromEmptyRoot_thenReturnsNull() {
        assertNull(emptyTree.root());
    }

    @Test
    void whenAddRootToEmptyTreeAndRoot_thenReturnsElement() {
        emptyTree.addRoot(0);
        assertEquals(0, emptyTree.root().getElement());
    }

    @Test
    void whenLeftOfRootFromExample_thenReturnsOne() {
        assertEquals(1, exampleTree.left(exampleTree.root).getElement());
    }

    @Test
    void whenRightOfRootFromExample_thenReturnsTwo() {
        assertEquals(2, exampleTree.right(exampleTree.root).getElement());
    }
}