package projects.trees;

import base.trees.AbstractBinaryTree;
import base.trees.Position;

import java.util.Iterator;

public class ArrayBinaryTree<E> extends AbstractBinaryTree<E> {
    // ------- nested Node class ------
    protected class Node<E> implements Position<E> {
        private E element;
        private int index;

        public Node(E element, int index) {
            this.element = element;
            this.index = index;
        }

        public E getElement() {
            return element;
        }

        public int getIndex() {
            return index;
        }

        int getParentIndex() {
            return (index - 1) / 2;
        }

        int getLeftIndex() {
            return 2 * index + 1;
        }

        int getRightIndex() {
            return 2 * index + 2;
        }
    } // ------- end of nested Node class -------

    private boolean isValidIndex(int index) {
        return index >= 0 && index < data.length;
    }

    /**
     * Factory function to create a new node storing element e.
     */
    protected Node<E> createNode(E e, int index) {
        if (!isValidIndex(index)) throw new IllegalArgumentException("Invalid tree index, or capacity is full");
        data[index] = e;
        return new Node<>(e, index);
    }

    // ArrayBinaryTree instance variables
    public static final int CAPACITY = 1000;    // default array capacity
    private E[] data;                           // generic array used for storage
    protected Node<E> root = null;              // root of the tree
    private int size = 0;                       // number of nodes in the tree

    // constructor
    public ArrayBinaryTree() {
        this(CAPACITY);
    }     // constructs stack with default capacity

    public ArrayBinaryTree(int capacity) {           // constructs stack with given capacity
        data = (E[]) new Object[capacity];           // safe cast; compiler may give warning
    }

    // Non-public utility

    /**
     * Validates the position and returns it as a node.
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p;                 // safe cast
        if (node.getIndex() > data.length || node.getIndex() < 0)
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    // accessor methods
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        int leftIndex = node.getLeftIndex();
        return new Node<>(data[leftIndex], leftIndex);
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        int rightIndex = node.getRightIndex();
        return new Node<>(data[rightIndex], rightIndex);
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        int parentIndex = node.getParentIndex();
        return new Node<>(data[parentIndex], parentIndex);
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getIndex() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    // update methods

    /**
     * Places element e at the root of an empty tree and returns its new Position.
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, 0);
        size = 1;
        return root;
    }

    /**
     * Creates a new left child of Position p storing element e; returns its Position.
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (data[parent.getLeftIndex()] != null) throw new IllegalArgumentException("p already has a left child");
        Node<E> child = createNode(e, parent.getLeftIndex());
        size++;
        return child;
    }

    /**
     * Creates a new right child of Position p storing element e; returns its Position.
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (data[parent.getRightIndex()] != null) throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent.getRightIndex());
        size++;
        return child;
    }
}