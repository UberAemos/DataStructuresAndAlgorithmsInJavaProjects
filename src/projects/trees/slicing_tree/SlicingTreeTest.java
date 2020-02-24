package projects.trees.slicing_tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlicingTreeTest {

    SlicingTree slicingTree;

    String singleBasicRectangle = "0";
    String treeWithHorizontalCut = "- (1, 2)";
    String treeWithVerticalCut = "| (1, 2)";
    String treeFloorPlan = "- (| (1, - (2, | (3, 4))), | (5, 6))";

    @BeforeEach
    void init() {
        slicingTree = new SlicingTree(10, 20);
    }

    @Test
    void whenSingleBasicRectangleIsAdded_thenReturnSingleBasicRectangle() {
        assertEquals(singleBasicRectangle, slicingTree.toString());
    }

    @Test
    void whenDecomposeWithHorizontalCut_thenReturnTreeWithHorizontalCut() {
        slicingTree.horizontalCut(slicingTree.root());
        assertEquals(treeWithHorizontalCut, slicingTree.toString());
    }

    @Test
    void whenDecomposeWithVerticalCut_thenReturnTreeWithVerticalCut() {
        slicingTree.verticalCut(slicingTree.root());
        assertEquals(treeWithVerticalCut, slicingTree.toString());
    }
}