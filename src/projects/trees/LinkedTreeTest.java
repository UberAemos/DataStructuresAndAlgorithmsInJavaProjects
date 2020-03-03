package projects.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedTreeTest {

    LinkedTree<Integer> exampleTree;

    @BeforeEach
    void init() {
        exampleTree = new LinkedTree<>();
        exampleTree.addRoot(0);
        exampleTree.addChild(1, exampleTree.root());
        exampleTree.addChild(2, exampleTree.root());
        exampleTree.addChild(3, exampleTree.root());
        exampleTree.addChild(4, exampleTree.children(exampleTree.root()).iterator().next());
        exampleTree.addChild(5, exampleTree.children(exampleTree.root()).iterator().next());
    }

    @Test
    void makePositionRoot_InnerNode() {
        exampleTree.makePositionRoot(exampleTree.children(exampleTree.root()).iterator().next());
        assertEquals(1, exampleTree.root().getElement());
        assertEquals(4, exampleTree.children(exampleTree.root()).iterator().next().getElement());
        assertEquals(3, exampleTree.size());
    }

    @Test
    void makePositionRoot_Leaf() {
        exampleTree.makePositionRoot(exampleTree.children(
                exampleTree.children(
                        exampleTree.root()).iterator().next())
                .iterator().next());
        assertEquals(4, exampleTree.root().getElement());
        assertEquals(1, exampleTree.size());
    }
}