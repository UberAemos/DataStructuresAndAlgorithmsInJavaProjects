package projects.trees.slicing_tree;

/**
 * Rectangle slice with minimum width and height.
 */
public class RectangleSlice extends Slice {

    protected int width;
    protected int height;

    public RectangleSlice(String element, int width, int height) {
        super(element);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
