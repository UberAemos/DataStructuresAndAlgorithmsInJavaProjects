package projects.trees.slicing_tree;

import base.trees.AbstractBinaryTree;
import base.trees.BinaryTree;
import base.trees.LinkedBinaryTree;
import base.trees.Position;

import java.util.Iterator;


/**
 * A slicing floor plan divides a rectangle with horizontal and vertical sides using horizontal and vertical cuts.
 * A slicing floor plan can be represented by a proper binary tree, called a slicing tree, whose internal nodes
 * represent the cuts, and whose external nodes represent the basic rectangles into which the floor plan is decomposed
 * by the cuts.
 */
public class SlicingTree extends AbstractBinaryTree<Slice> implements BinaryTree<Slice> {
    LinkedBinaryTree<Slice> slicingTree;

    public SlicingTree(int width, int height) {
        slicingTree = new LinkedBinaryTree<>();
        RectangleSlice rectangleSlice = new RectangleSlice("0", width, height);
        slicingTree.addRoot(rectangleSlice);
    }

    /**
     * Makes a horizontal cut in the given basic rectangle position
     *
     * @param p Tree position that contains a basic rectangle
     * @throws IllegalArgumentException If the given position do not contain a basic rectangle
     */
    public void horizontalCut(Position<Slice> p) throws IllegalArgumentException {
        if (slicingTree.numChildren(p) != 0)
            throw new IllegalArgumentException("Given position is not a simple rectangle");
        RectangleSlice element = (RectangleSlice) p.getElement();
        slicingTree.addLeft(p, new RectangleSlice(
                Integer.toString(Integer.parseInt(element.getElement()) + 1),
                element.getWidth() / 2,
                element.getHeight()));
        slicingTree.addRight(p, new RectangleSlice(
                Integer.toString(Integer.parseInt(element.getElement()) + 2),
                element.getWidth() / 2,
                element.getHeight()));
        slicingTree.set(p, new HorizontalCutSlice());
    }

    /**
     * Makes a vertical cut in the given basic rectangle position
     *
     * @param p Position should have a RectangleSlice
     * @throws IllegalArgumentException If the given position do not contain a basic rectangle
     */
    public void verticalCut(Position<Slice> p) throws IllegalArgumentException {
        if (slicingTree.numChildren(p) != 0)
            throw new IllegalArgumentException("Given position is not a simple rectangle");
        RectangleSlice element = (RectangleSlice) p.getElement();
        slicingTree.addLeft(p, new RectangleSlice(
                Integer.toString(Integer.parseInt(element.getElement()) + 1),
                element.getWidth(),
                element.getHeight() / 2));
        slicingTree.addRight(p, new RectangleSlice(
                Integer.toString(Integer.parseInt(element.getElement()) + 2),
                element.getWidth(),
                element.getHeight() / 2));
        slicingTree.set(p, new VerticalCutSlice());
    }

    /**
     * Returns the width of the given position.
     *
     * @param p Tree position that can either be a CutSlice or RectangleSlice
     * @return The total width of the given position
     */
    public int width(Position<Slice> p) {
        if (slicingTree.numChildren(p) == 0) return ((RectangleSlice) p.getElement()).getWidth();
        if (isVerticalCut(p)) return width(slicingTree.left(p)) + width(slicingTree.right(p));
        return Math.max(width(slicingTree.left(p)), width(slicingTree.right(p)));
    }

    /**
     * Returns the height of the given position.
     *
     * @param p Tree position that can either be a CutSlice or RectangleSlice
     * @return The total height of the given position
     */
    public int height(Position<Slice> p) {
        if (slicingTree.numChildren(p) == 0) return ((RectangleSlice) p.getElement()).getHeight();
        if (!isVerticalCut(p)) return height(slicingTree.left(p)) + height(slicingTree.right(p));
        return Math.max(height(slicingTree.left(p)), height(slicingTree.right(p)));
    }

    public Position<Slice> left(Position<Slice> p) throws IllegalArgumentException {
        return slicingTree.left(p);
    }

    public Position<Slice> right(Position<Slice> p) throws IllegalArgumentException {
        return slicingTree.right(p);
    }

    public Position<Slice> root() {
        return slicingTree.root();
    }

    public Position<Slice> parent(Position<Slice> p) throws IllegalArgumentException {
        return slicingTree.parent(p);
    }

    public boolean isRoot(Position<Slice> p) throws IllegalArgumentException {
        return slicingTree.isRoot(p);
    }

    public int size() {
        return slicingTree.size();
    }

    public Iterator<Slice> iterator() {
        return null;
    }

    public Iterable<Position<Slice>> positions() {
        return null;
    }

    private boolean isVerticalCut(Position<Slice> p) {
        return Cut.VERTICAL.getSign().equals(p.getElement().getElement());
    }

    @Override
    public String toString() {
        return AbstractBinaryTree.parenthesize(slicingTree, slicingTree.root());
    }
}
