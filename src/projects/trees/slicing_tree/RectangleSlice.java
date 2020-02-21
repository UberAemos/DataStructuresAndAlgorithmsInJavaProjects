package projects.trees.slicing_tree;

/**
 * Rectangle slice with minimum width and height.
 */
public class RectangleSlice extends Slice {

    private int width;
    private int height;

    public RectangleSlice(String element, int width, int height) {
        super(element);
        this.width = width;
        this.height = height;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
}
