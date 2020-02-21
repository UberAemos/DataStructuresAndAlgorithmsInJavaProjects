package projects.trees.slicing_tree;

import base.trees.LinkedBinaryTree;
import base.trees.Position;


/**
 * A slicing floor plan divides a rectangle with horizontal and vertical sides using horizontal and vertical cuts.
 * A slicing floor plan can be represented by a proper binary tree, called a slicing tree, whose internal nodes
 * represent the cuts, and whose external nodes represent the basic rectangles into which the floor plan is decomposed
 * by the cuts.
 */
public class SlicingTree {
    LinkedBinaryTree<Slice> slicingTree = new LinkedBinaryTree<>();

    /**
     * Makes a horizontal cut in the given basic rectangle position
     *
     * @param p Tree position that contains a basic rectangle
     * @throws IllegalArgumentException If the given position do not contain a basic rectangle
     */
    public void horizontalCut(Position<Slice> p) throws IllegalArgumentException {

    }

    /**
     * Makes a vertical cut in the given basic rectangle position
     *
     * @param p Position should have a RectangleSlice
     * @throws IllegalArgumentException If the given position do not contain a basic rectangle
     */
    public void verticalCut(Position<Slice> p) throws IllegalArgumentException {

    }

    /**
     * Returns the width of the given position.
     *
     * @param p Tree position that can either be a CutSlice or RectangleSlice
     * @return The total width of the given position
     */
    public int width(Position<Slice> p) {
        return 0;
    }

    /**
     * Returns the height of the given position.
     *
     * @param p Tree position that can either be a CutSlice or RectangleSlice
     * @return The total height of the given position
     */
    public int height(Position<Slice> p) {
        return 0;
    }
}
