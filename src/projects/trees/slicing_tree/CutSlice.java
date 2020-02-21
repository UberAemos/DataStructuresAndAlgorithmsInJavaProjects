package projects.trees.slicing_tree;

public abstract class CutSlice extends Slice {
    public CutSlice(Cut cut) {
        super(cut.getSign());
    }
}
