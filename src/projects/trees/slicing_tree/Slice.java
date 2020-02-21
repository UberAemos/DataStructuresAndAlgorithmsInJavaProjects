package projects.trees.slicing_tree;

/**
 * Defines a slice that is either a basic rectangle or a cut that is horizontal or vertical.
 */
abstract class Slice {
    private String element;

    public Slice(String element) {
        this.element = element;
    }

    public abstract int width();

    public abstract int height();

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
