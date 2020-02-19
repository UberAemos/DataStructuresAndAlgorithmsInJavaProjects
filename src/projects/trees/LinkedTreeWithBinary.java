package projects.trees;

import base.trees.AbstractTree;
import base.trees.LinkedBinaryTree;
import base.trees.Position;
import base.trees.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedTreeWithBinary<E> extends AbstractTree<E> implements Tree<E> {
    LinkedBinaryTree<E> binaryTree = new LinkedBinaryTree<>();

    public Position<E> root() {
        return binaryTree.root();
    }

    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        if (binaryTree.isRoot(p)) return null;

        Position<E> walk = binaryTree.parent(p);
        while (binaryTree.left(walk) != p) walk = binaryTree.parent(walk);
        return walk;
    }

    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> children = new ArrayList<>();
        Position<E> walk = binaryTree.left(p);
        while (walk != null) {
            children.add(walk);
            walk = binaryTree.right(walk);
        }
        return children;
    }

    public int numChildren(Position<E> p) throws IllegalArgumentException {
        int numChildren = 0;
        Position<E> walk = binaryTree.left(p);
        while (walk != null) {
            numChildren++;
            walk = binaryTree.right(walk);
        }
        return numChildren;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return binaryTree.isRoot(p);
    }

    @Override
    public int size() {
        return binaryTree.size();
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    // update methods supported by this class

    /**
     * Places element e at the root of an empty tree and returns its new Position.
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        return binaryTree.addRoot(e);
    }

    /**
     * Places element e as a child node of given parent p
     */
    public Position<E> addChild(E e, Position<E> p) throws IllegalArgumentException {
        if (binaryTree.left(p) == null) return binaryTree.addLeft(p, e);
        Position<E> walk = binaryTree.left(p);
        while (binaryTree.right(walk) != null) walk = binaryTree.right(walk);
        return binaryTree.addRight(walk, e);
    }
}
