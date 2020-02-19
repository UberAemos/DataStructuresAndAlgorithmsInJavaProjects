package projects.trees;

import base.trees.AbstractTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedTreeWithBinaryTest {

    LinkedTreeWithBinary<Integer> emptyTree;
    LinkedTreeWithBinary<Integer> exampleTree;

    @BeforeEach
    void init() {
        emptyTree = new LinkedTreeWithBinary<>();

        exampleTree = new LinkedTreeWithBinary<>();
        exampleTree.addRoot(0);
        exampleTree.addChild(1, exampleTree.root());
        exampleTree.addChild(2, exampleTree.root());
        exampleTree.addChild(3, exampleTree.root());
    }

    @Test
    void whenAddZeroAsRoot_thenPrintsZero() {
        emptyTree.addRoot(0);
        assertEquals("0", AbstractTree.parenthesize(emptyTree, emptyTree.root()));
    }

    @Test
    void whenAddMultiple_thenPrintsMultiple() {
        emptyTree.addRoot(0);
        emptyTree.addChild(1, emptyTree.root());
        emptyTree.addChild(2, emptyTree.root());
        emptyTree.addChild(3, emptyTree.root());
        assertEquals("0 (1, 2, 3)", AbstractTree.parenthesize(emptyTree, emptyTree.root()));
    }

    @Test
    void whenFirstChildrenOfZero_thenReturnsOne() {
        assertEquals(1, exampleTree.children(exampleTree.root()).iterator().next().getElement());
    }

    @Test
    void whenNumChildrenOfZero_thenReturnsThree() {
        assertEquals(3, exampleTree.numChildren(exampleTree.root()));
    }

    @Test
    void whenParentOfOne_thenReturnsZero() {
        assertEquals(0, exampleTree.parent(exampleTree.children(exampleTree.root()).iterator().next()).getElement());
    }

}