package projects.stacks_queues_dequeues.double_stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayDoubleStackTest {

    ArrayDoubleStack emptyDoubleStack;
    ArrayDoubleStack exampleDoubleStack;

    @BeforeEach
    void init() {
        emptyDoubleStack = new ArrayDoubleStack();
        exampleDoubleStack = new ArrayDoubleStack();
    }

    @Test
    void whenEmptyStackIsPrinted_itPrintsInCorrectFormat() {
        assertEquals("ArrayDoubleStack{" +
                        "blue=[], " +
                        "red=[]}",
                emptyDoubleStack.toString());
    }

    @Test
    void redSize() {
    }

    @Test
    void blueSize() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void isBlueEmpty() {
    }

    @Test
    void isRedEmpty() {
    }

    @Test
    void bluePush() {
    }

    @Test
    void blueTop() {
    }

    @Test
    void bluePop() {
    }

    @Test
    void redPush() {

    }

    @Test
    void redTop() {
    }

    @Test
    void redPop() {
    }
}