package projects.fundamental;

import base.fundamental.GameEntry;
import base.fundamental.SinglyLinkedList;

/**
 * Maintains the top ten scores for a game application using a singly linked list.
 */
public class SinglyLinkedScoreBoard {
    final private static int capacity = 10;                                    // total capacity of this scoreboard
    private SinglyLinkedList<GameEntry> board = new SinglyLinkedList<>();      // list of game entries (names & scores)

    /**
     * Attempt to add a new score to the collection (if it is high enough)
     */
    public void add(GameEntry e) {
        int newScore = e.getScore();
        // is the new entry e really a high score?
        if (board.size() < capacity || newScore > board.first().getScore()) {
            // if smallest score so far add it to the head
            if (board.isEmpty() || board.first().getScore() > e.getScore()) board.addFirst(e);
                // else insert it at the top of closest smaller element
            else {
                SinglyLinkedList.Node<GameEntry> walk = board.getHead();
                while (walk != null)
                    if (walk.getNext() == null || walk.getNext().getElement().getScore() > e.getScore()) {
                        walk.setNext(new SinglyLinkedList.Node<>(e, walk.getNext()));
                        board.setSize(board.size() + 1);
                        break;
                    } else walk = walk.getNext();
            }
            // if capacity is exceeded remove the first element
            if (board.size() > capacity) board.removeFirst();
        }
    }

    /**
     * Removes and return the high score at index i.
     */
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= board.size())
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        if (i == 0) return board.removeFirst();
        int currentIndex = 1;
        SinglyLinkedList.Node<GameEntry> walk = board.getHead();
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
