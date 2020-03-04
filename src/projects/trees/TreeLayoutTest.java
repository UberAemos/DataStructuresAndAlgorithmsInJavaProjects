package projects.trees;

import base.trees.LinkedBinaryTree;
import base.trees.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeLayoutTest {

    LinkedBinaryTree<Integer> oneNodeBinaryTree;
    LinkedBinaryTree<Integer> simpleBinaryTree;
    LinkedBinaryTree<Integer> complexBinaryTree;

    LinkedTree<Integer> oneNodeTree;
    LinkedTree<Integer> simpleTree;
    LinkedTree<Integer> complexTree;

    private String oneNodeBinaryTreeRepresentation = "0";
    private String simpleBinaryTreeRepresentation = "0\n|--1\n|--2";
    private String complexBinaryTreeRepresentation = "0\n|--1\n|  |--3\n|--2\n|  |--4\n|  |--5\n|  |  |--6";

    private String oneNodeTreeRepresentation = "0";
    private String simpleTreeRepresentation = "0\n|--1\n|--2\n|--3";
    private String complexTreeRepresentation = "0\n|--1\n|  |--4\n|  |--5\n|--2\n|  |--6\n|  |  |--7\n|--3";

    @BeforeEach
    void init() {
        oneNodeBinaryTree = new LinkedBinaryTree<>();
        oneNodeBinaryTree.addRoot(0);

        simpleBinaryTree = new LinkedBinaryTree<>();
        simpleBinaryTree.addRoot(0);
        simpleBinaryTree.addLeft(simpleBinaryTree.root(), 1);
        simpleBinaryTree.addRight(simpleBinaryTree.root(), 2);

        complexBinaryTree = new LinkedBinaryTree<>();
        complexBinaryTree.addRoot(0);
        complexBinaryTree.addLeft(complexBinaryTree.root(), 1);
        complexBinaryTree.addRight(complexBinaryTree.root(), 2);
        complexBinaryTree.addRight(complexBinaryTree.left(complexBinaryTree.root()), 3);
        complexBinaryTree.addLeft(complexBinaryTree.right(complexBinaryTree.root()), 4);
        complexBinaryTree.addRight(complexBinaryTree.right(complexBinaryTree.root()), 5);
        complexBinaryTree.addRight(complexBinaryTree.right(complexBinaryTree.right(complexBinaryTree.root())), 6);

        oneNodeTree = new LinkedTree<>();
        oneNodeTree.addRoot(0);

        simpleTree = new LinkedTree<>();
        simpleTree.addRoot(0);
        simpleTree.addChild(1, simpleTree.root);
        simpleTree.addChild(2, simpleTree.root);
        simpleTree.addChild(3, simpleTree.root);

        complexTree = new LinkedTree<>();
        complexTree.addRoot(0);
        complexTree.addChild(1, complexTree.root);
        complexTree.addChild(2, complexTree.root);
        complexTree.addChild(3, complexTree.root);

        Iterator<Position<Integer>> iterator = complexTree.children(complexTree.root).iterator();
        Position<Integer> next = iterator.next();
        complexTree.addChild(4, next);
        complexTree.addChild(5, next);
        next = iterator.next();
        complexTree.addChild(6, next);

        iterator = complexTree.children(next).iterator();
        next = iterator.next();
        complexTree.addChild(7, next);
    }

    @Test
    void whenOneNodeBinaryTreeIsDrawn_thenReturnsOneNodeBinaryTreeRepresentation() {
        assertEquals(oneNodeBinaryTreeRepresentation, TreeLayout.drawTree(oneNodeBinaryTree));
    }

    @Test
    void whenSimpleBinaryTreeIsDrawn_thenReturnsOneNodeBinaryTreeRepresentation() {
        assertEquals(simpleBinaryTreeRepresentation, TreeLayout.drawTree(simpleBinaryTree));
    }

    @Test
    void whenComplexBinaryTreeIsDrawn_thenReturnsOneNodeBinaryTreeRepresentation() {
        assertEquals(complexBinaryTreeRepresentation, TreeLayout.drawTree(complexBinaryTree));
    }

    @Test
    void whenOneNodeTreeIsDrawn_thenReturnsOneNodeTreeRepresentation() {
        assertEquals(oneNodeTreeRepresentation, TreeLayout.drawTree(oneNodeTree));
    }

    @Test
    void whenSimpleTreeIsDrawn_thenReturnsOneNodeTreeRepresentation() {
        assertEquals(simpleTreeRepresentation, TreeLayout.drawTree(simpleTree));
    }

    @Test
    void whenComplexTreeIsDrawn_thenReturnsOneNodeTreeRepresentation() {
        assertEquals(complexTreeRepresentation, TreeLayout.drawTree(complexTree));
    }

}