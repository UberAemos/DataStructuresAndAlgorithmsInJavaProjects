package projects.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionTreeTest {
    String invalidExpression1 = "3 *";
    String invalidExpression2 = "3 * 5 + 3";
    String invalidExpression3 = "3 * +";

    @Test
    void whenInvalidArithmeticExpressionGivenToConvert_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> ExpressionTree.convertToExpressionTree(invalidExpression1));
        assertThrows(IllegalArgumentException.class, () -> ExpressionTree.convertToExpressionTree(invalidExpression2));
        assertThrows(IllegalArgumentException.class, () -> ExpressionTree.convertToExpressionTree(invalidExpression3));
    }
}