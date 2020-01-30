package projects.stacks_queues_dequeues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PostfixEvaluatorTest {
    private final String invalidExpressionMissingParentheses = "(5 + 3";
    private final String invalidExpressionMissingValue = "(5 + )";

    private final String simpleExpression = "(5 + 3)";

    private final String complexExpression = "(((5 + 3) * 12) - (6 / 2))";

    @Test
    void whenEmptyExpressionIsGiven_illegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class,
                () -> PostfixEvaluator.evaluatePostfix(""));
    }

    @Test
    void whenSingleValueIsGiven_returnsSingleValue() {
        assertEquals(5, PostfixEvaluator.evaluatePostfix("5"));
    }

    @Test
    void whenInvalidExpressionWithMissingParenthesis_illegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class,
                () -> PostfixEvaluator.evaluatePostfix(invalidExpressionMissingParentheses));
    }

    @Test
    void whenInvalidExpressionMissingValue_illegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class,
                () -> PostfixEvaluator.evaluatePostfix(invalidExpressionMissingValue));
    }

    @Test
    void whenSimpleExpressionIsGiven_returnSimplePostfix() {
        assertEquals(8, PostfixEvaluator.evaluatePostfix(simpleExpression));
    }

    @Test
    void whenComplexExpressionIsGiven_returnComplexPostfix() {
        assertEquals(93, PostfixEvaluator.evaluatePostfix(complexExpression));
    }
}