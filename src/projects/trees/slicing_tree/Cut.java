package projects.trees.slicing_tree;

/**
 * Represents a horizontal or vertical cut.
 */
public enum Cut {

    HORIZONTAL("-"),
    VERTICAL("|");

    private String sign;

    Cut(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
