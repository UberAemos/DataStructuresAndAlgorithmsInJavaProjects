package projects.stacks_queues_dequeues.double_stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void whenTopInEmptyBlueStack_thenReturnsNull() {
        assertNull(emptyDoubleStack.blueTop());
    }

    @Test
    void whenTopInEmptyRedStack_thenReturnsNull() {
        assertNull(emptyDoubleStack.redTop());
    }

    @Test
    void whenTopBlueInExampleStack_thenReturnsThree() {
        assertEquals(3, exampleDoubleStack.blueTop());
    }

    @Test
    void whenTopRedInExampleStack_thenReturnsFiveHundredAndOne() {
        assertEquals(501, exampleDoubleStack.redTop());
    }

    @Test
    void whenPopInEmptyBlueStack_thenReturnsNull() {
        assertNull(emptyDoubleStack.bluePop());
    }

    @Test
    void whenPopInEmptyRedStack_thenReturnsNull() {
        assertNull(emptyDoubleStack.redPop());
    }

    @Test
    void whenPopBlueInExampleStack_thenReturnsThree_sizeEqualsTwo_topElementIsTwo() {
        assertEquals(3, exampleDoubleStack.bluePop());
        assertEquals(2, exampleDoubleStack.blueSize());
        assertEquals(2, exampleDoubleStack.blueTop());
    }

    @Test
    void whenPopRedInExampleStack_thenReturnsFiveHundredAndOne_sizeEqualsOne_topElementIsFiveHundred() {
        assertEquals(501, exampleDoubleStack.redPop());
        assertEquals(1, exampleDoubleStack.redSize());
        assertEquals(500, exampleDoubleStack.redTop());
    }
}