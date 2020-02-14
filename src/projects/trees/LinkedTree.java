package projects.trees;

import base.trees.AbstractTree;
import base.trees.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedTree<E> extends AbstractTree<E> {
    // ------- nested Node class -------
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private List<Position<E>> children;

        public Node(E element, Node<E> parent, List<Position<E>> children) {
            this.element = element;
            this.parent = parent;
            this.children = children;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public List<? extends Position<E>> getChildren() {
            return children;
        }

        public void addChild(Position<E> child) {
            this.children.add(child);
        }
    }

    // LinkedAbstractTree instance variables
    protected Node<E> root = null;
    protected int size = 0;

    // non-public utility

    /**
     * Validates the position and returns it as a node.
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p; // Safe cast
        if (node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    // accessor methods (not already implemented in AbstractBinaryTree)

    /**
     * Returns the root Position of the tree (or null for empty tree).
     */
    public Position<E> root() {
        return root;
    }

    /**
     * Returns the number of nodes in the tree.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the Position of p's parent (or null if p is root).
     */
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * Returns a list of child nodes of this position (or empty list if p is leaf).
     */
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return (Iterable<Position<E>>) node.getChildren();
    }

    /**
     * Returns the outermost number of children that belongs to p.
     */
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getChildren().size();
    }

    /**
     * Returns true if p is the root.
     */
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent() == null;
    }

    // update methods supported by this class

    /**
     * Places element e at the root of an empty tree and returns its new Position.
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = new Node<E>(e, null, new ArrayList<>());
        size = 1;
        return root;
    }

    /**
     * Places element e as a child node of given parent p
     */
    public Position<E> addChild(E e, Position<E> p) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        Position<E> node = new Node<>(e, parent, new ArrayList<>());
        parent.addChild(node);
        return root;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }
}
