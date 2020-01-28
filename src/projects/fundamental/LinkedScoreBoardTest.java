package projects.fundamental;

import base.fundamental.GameEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedScoreBoardTest {
    LinkedScoreBoard emptyBoard;
    LinkedScoreBoard fullBoard;

    GameEntry gameEntry1 = new GameEntry("John", 250);
    GameEntry gameEntry2 = new GameEntry("Jane", 400);
    GameEntry gameEntry3 = new GameEntry("Jim", 100);
    GameEntry gameEntry4 = new GameEntry("Joshua", 150);
    GameEntry gameEntry5 = new GameEntry("Johanna", 300);

    @BeforeEach
    void init() {
        emptyBoard = new LinkedScoreBoard();
        fullBoard = new LinkedScoreBoard();
        fullBoard.add(gameEntry1);
        fullBoard.add(gameEntry1);
        fullBoard.add(gameEntry2);
        fullBoard.add(gameEntry2);
        fullBoard.add(gameEntry3);
        fullBoard.add(gameEntry3);
        fullBoard.add(gameEntry4);
        fullBoard.add(gameEntry4);
        fullBoard.add(gameEntry5);
        fullBoard.add(gameEntry5);
    }

    @Test
    void whenAddElementToEmptyBoard_itIsTheFirstElement() {
        emptyBoard.add(gameEntry1);
        assertEquals("[(John, 250)]", emptyBoard.toString());
    }

    @Test
    void whenAddBiggerScoreToSingleElementList_itIsTheLastElement() {
        emptyBoard.add(gameEntry1);
        emptyBoard.add(gameEntry2);
        assertEquals("[(John, 250), (Jane, 400)]", emptyBoard.toString());
    }

    @Test
    void whenAddSmallerScoreToSingleElementList_itIsTheFirstElement() {
        emptyBoard.add(gameEntry2);
        emptyBoard.add(gameEntry1);
        assertEquals("[(John, 250), (Jane, 400)]", emptyBoard.toString());
    }

    @Test
    void whenAddSmallerScoreToFullBoard_itDoesNotAdd() {
        fullBoard.add(gameEntry3);
        assertEquals("" +
                        "[(Jim, 100), (Jim, 100), " +
                        "(Joshua, 150), (Joshua, 150), " +
                        "(John, 250), (John, 250), " +
                        "(Johanna, 300), (Johanna, 300), " +
                        "(Jane, 400), (Jane, 400)]",
                fullBoard.toString());
    }

    @Test
    void whenAddLargerScoreToFullBoard_itAddsAndRemovesFirst() {
        fullBoard.add(gameEntry1);
        assertEquals("" +
                        "[(Jim, 100), " +
                        "(Joshua, 150), (Joshua, 150), " +
                        "(John, 250), (John, 250), (John, 250), " +
                        "(Johanna, 300), (Johanna, 300), " +
                        "(Jane, 400), (Jane, 400)]",
                fullBoard.toString());
    }

    @Test
    void remove() {
    }
}