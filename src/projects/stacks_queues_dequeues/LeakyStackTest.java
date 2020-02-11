package projects.stacks_queues_dequeues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeakyStackTest {

    LeakyStack<Integer> emptyLeakyStack;
    LeakyStack<Integer> fullLeakyStack;

    @BeforeEach
    void init() {
        emptyLeakyStack = new LeakyStack<>();

        fullLeakyStack = new LeakyStack<>(5);
        for (int i = 0; i < 5; i++) fullLeakyStack.push(i);
    }

    @Test
    void whenSizeInEmptyStack_thenReturnsZero() {
        assertEquals(0, emptyLeakyStack.size());
    }

    @Test
    void whenSizeInFullStack_thenReturnsFive() {
        assertEquals(5, fullLeakyStack.size());
    }

    @Test
    void whenIsEmptyInEmptyList_returnsTrue() {
        assertTrue(emptyLeakyStack.isEmpty());
    }

    @Test
    void whenIsEmptyInFullList_returnsFalse() {
        assertFalse(fullLeakyStack.isEmpty());
    }

    @Test
    void whenPushOneToEmptyStack_sizeIsOne_stackStartsWithOne() {
        emptyLeakyStack.push(1);
        assertEquals("[1]", emptyLeakyStack.toString());
        assertEquals(1, emptyLeakyStack.size());
        assertEquals(1, emptyLeakyStack.top());
    }

    @Test
    void whenPushSixToFullStack_sizeIsFive_stackStartsWithSix_oneHasRemoved() {
        fullLeakyStack.push(5);
        assertEquals("[5, 4, 3, 2, 1]", fullLeakyStack.toString());
        assertEquals(5, fullLeakyStack.size());
        assertEquals(5, fullLeakyStack.top());
    }
}