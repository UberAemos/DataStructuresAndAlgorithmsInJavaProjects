package projects.stacks_queues_dequeues.double_stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayDoubleStackTest {

    ArrayDoubleStack<Integer> emptyDoubleStack;
    ArrayDoubleStack<Integer> exampleDoubleStack;
    ArrayDoubleStack<Integer> fullStack;

    @BeforeEach
    void init() {
        emptyDoubleStack = new ArrayDoubleStack<>();

        exampleDoubleStack = new ArrayDoubleStack<>();
        exampleDoubleStack.bluePush(1);
        exampleDoubleStack.bluePush(2);
        exampleDoubleStack.bluePush(3);
        exampleDoubleStack.redPush(500);
        exampleDoubleStack.redPush(501);

        fullStack = new ArrayDoubleStack<>();
        for (int i = 0; i < 500; i++) fullStack.bluePush(i);
        for (int i = 500; i < 1000; i++) fullStack.redPush(i);
    }

    @Test
    void whenEmptyStackIsPrinted_itPrintsInCorrectFormat() {
        assertEquals("ArrayDoubleStack{" +
                        "blueStack=[], " +
                        "redStack=[]}",
                emptyDoubleStack.toString());
    }

    @Test
    void whenElementIsPushedToEmptyStacksBlueStack_thenPrintsElementWithinBlueStack() {
        emptyDoubleStack.bluePush(1);
        assertEquals("ArrayDoubleStack{" +
                        "blueStack=[1], " +
                        "redStack=[]}",
                emptyDoubleStack.toString());
    }

    @Test
    void whenElementIsPushedToEmptyStacksRedStack_thenPrintsElementWithinRedStack() {
        emptyDoubleStack.redPush(1);
        assertEquals("ArrayDoubleStack{" +
                        "blueStack=[], " +
                        "redStack=[1]}",
                emptyDoubleStack.toString());
    }

    @Test
    void whenRedAndBlueNonEmpty_thenPrintsElementWithinRedAndBlueStack() {
        assertEquals("ArrayDoubleStack{" +
                        "blueStack=[1, 2, 3], " +
                        "redStack=[500, 501]}",
                exampleDoubleStack.toString());
    }

    @Test
    void whenElementIsPushedToFullStackBlue_thenThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> fullStack.bluePush(1));
    }

    @Test
    void whenElementIsPushedToFullStackRed_thenThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> fullStack.redPush(1));
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