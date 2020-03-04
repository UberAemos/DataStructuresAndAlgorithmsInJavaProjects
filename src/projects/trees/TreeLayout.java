package projects.trees;

import base.trees.Position;
import base.trees.Tree;

import java.util.Iterator;

/**
 * Includes certain methods to draw schematic tree representations.
 */
public class TreeLayout {

    /**
     * Draws a binary tree in a schematic format
     *
     * @param T   Binary tree to be drawn
     * @param <E>
     * @return Schematic tree representation in String format
     */
    public static <E> String drawTree(Tree<E> T) {
        return drawNode(T, T.root(), new StringBuilder(), 0);
    }

    private static <E> String drawNode(Tree<E> t, Position<E> position, StringBuilder sb, int depth) {
        for (int i = 1; i < depth; i++) {
            sb.append("|  ");
        }
        if (depth != 0) sb.append("|--");
        sb.append(position.getElement());

        Iterator<Position<E>> iterator = t.children(position).iterator();
        while (iterator.hasNext()) {
            sb.append("\n");
            drawNode(t, iterator.next(), sb, depth + 1);
        }
        return sb.toString();
    }
}
