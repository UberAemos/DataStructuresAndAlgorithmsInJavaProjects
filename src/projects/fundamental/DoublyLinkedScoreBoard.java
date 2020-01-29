package projects.fundamental;

import base.fundamental.DoublyLinkedList;
import base.fundamental.GameEntry;

/**
 * Maintains the top ten scores for a game application using a doubly linked list.
 */
public class DoublyLinkedScoreBoard {
    private DoublyLinkedList<GameEntry> board = new DoublyLinkedList<>();
    final private static int capacity = 10;

    /**
     * Attempt to add a new score to the collection (if it is high enough)
     */
    public void add(GameEntry e) {
        int newScore = e.getScore();
        // is the new entry e really a high score?
        if (board.size() < capacity || newScore > board.first().getScore()) {
            // if smallest score so far add it to the head
            if (board.isEmpty()) board.addFirst(e);
                // else insert it at the top of closest smaller element
            else {
                DoublyLinkedList.Node<GameEntry> walk = board.getHead();
                while (walk.getNext() != null)
                    if (walk.getNext().getElement() == null) {
                        board.addLast(e);
                        break;
                    } else if (walk.getNext().getElement().getScore() > e.getScore()) {
                        DoublyLinkedList.Node newest = new DoublyLinkedList.Node<>(e, walk, walk.getNext());
                        walk.getNext().setPrev(newest);
                        walk.setNext(newest);
                        board.setSize(board.size() + 1);
                        break;
                    } else walk = walk.getNext();
            }
            // if capacity is exceeded remove the first element
            if (board.size() > capacity) board.removeFirst();
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= board.size())
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        int currentIndex = 0;
        DoublyLinkedList.Node<GameEntry> walk = board.getHead();
        while (currentIndex < i) {
            walk = walk.getNext();
            currentIndex++;
        }
        GameEntry current = walk.getNext().getElement();
        walk.setNext(walk.getNext().getNext());
        board.setSize(board.size() - 1);
        return current;
    }

    public String toString() {
        return board.toString();
    }
}
