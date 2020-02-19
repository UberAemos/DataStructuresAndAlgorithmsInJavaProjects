package base.trees;

public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Prints parenthesized representation of subtree of T rooted at p.
     */
    public static <E> String parenthesize(Tree<E> T, Position<E> p) {
        StringBuilder builder = new StringBuilder(p.getElement().toString());
        if (T.isInternal(p)) {
            boolean firstTime = true;
            for (Position<E> c : T.children(p)) {
                builder.append(firstTime ? " (" : ", ");        // determine proper punctuation
                firstTime = false;
                builder.append(parenthesize(T, c));
            }
            return builder.append(")").toString();
        }
        return "";
    }
}
