package projects.trees.game_tree;

import base.fundamental.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTreeTest {

    TicTacToe easyGameForX;
    TicTacToe easyGameForO;

    String easyGameForXAnswer =
            "X|X|X" + "\n-----\n" + "O| | " + "\n-----\n" + "O| | ";
    String easyGameForOAnswer =
            "X|O|X" + "\n-----\n" + "X|O| " + "\n-----\n" + " |O| ";


    @BeforeEach
    void init() {
        easyGameForX = new TicTacToe();
        easyGameForX.putMark(0, 0);
        easyGameForX.putMark(1, 0);
        easyGameForX.putMark(0, 1);
        easyGameForX.putMark(2, 0);

        easyGameForO = new TicTacToe();
        easyGameForO.putMark(0, 0);
        easyGameForO.putMark(0, 1);
        easyGameForO.putMark(0, 2);
        easyGameForO.putMark(1, 1);
        easyGameForO.putMark(1, 0);
        easyGameForO.putMark(2, 1);
    }

    @Test
    void whenEasyGameForXIsGiven_returnEasyGameForXAnswer() {
        assertEquals(
                easyGameForXAnswer,
                GameTree.pickMove(easyGameForX).toString());
    }

    @Test
    void whenEasyGameForOIsGiven_returnEasyGameForOAnswer() {
        assertEquals(
                easyGameForOAnswer,
                GameTree.pickMove(easyGameForO).toString());
    }
}