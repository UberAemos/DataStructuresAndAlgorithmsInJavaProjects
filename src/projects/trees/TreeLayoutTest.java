package projects.trees;

import base.trees.LinkedBinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeLayoutTest {

    LinkedBinaryTree<Integer> oneNodeTree;
    LinkedBinaryTree<Integer> simpleTree;
    LinkedBinaryTree<Integer> complexTree;

    private String oneNodeTreeRepresentation = "0";
    private String simpleTreeRepresentation = "0\n|--1\n|--2";
    private String complexTreeRepresentation = "0\n|--1\n|  |--3\n|--2\n|  |--4\n|  |--5\n|  |  |--6\n";

    @BeforeEach
    void init() {
        oneNodeTree = new LinkedBinaryTree<>();
        oneNodeTree.addRoot(0);

        simpleTree = new LinkedBinaryTree<>();
        simpleTree.addRoot(0);
        simpleTree.addLeft(simpleTree.root(), 1);
        simpleTree.addRight(simpleTree.root(), 2);

        complexTree = new LinkedBinaryTree<>();
        complexTree.addRoot(0);
        complexTree.addLeft(complexTree.root(), 1);
        complexTree.addRight(complexTree.root(), 2);
        complexTree.addRight(complexTree.left(complexTree.root()), 3);
        complexTree.addLeft(complexTree.right(complexTree.root()), 4);
        complexTree.addRight(complexTree.right(complexTree.root()), 5);
        complexTree.addRight(complexTree.right(complexTree.right(complexTree.root())), 6);
    }

    @Test
    void whenOneNodeTreeIsDrawn_thenReturnsOneNodeTreeRepresentation() {
        assertEquals(oneNodeTreeRepresentation, TreeLayout.drawBinaryTree(oneNodeTree));
    }

    @Test
    void whenSimpleTreeIsDrawn_thenReturnsOneNodeTreeRepresentation() {
        assertEquals(simpleTreeRepresentation, TreeLayout.drawBinaryTree(simpleTree));
    }

    @Test
    void whenComplexTreeIsDrawn_thenReturnsOneNodeTreeRepresentation() {
        assertEquals(complexTreeRepresentation, TreeLayout.drawBinaryTree(complexTree));
    }

}