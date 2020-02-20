package projects.trees;

import base.trees.AbstractBinaryTree;
import base.trees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionTreeTest {
    String invalidExpression1 = "3 *";
    String invalidExpression2 = "3 * 5 + 3";
    String invalidExpression3 = "3 * +";

    String validExpression1 = "(3 + 5)";
    String validExpression2 = "(3 + (5 * 6))";
    String validExpression3 = "((3 / 4) + (5 * 6))";

    String validTree1 = "+ (3, 5)";
    String validTree2 = "+ (3, * (5, 6))";
    String validTree3 = "+ (/ (3, 4), * (5, 6))";

    @Test
    void whenInvalidArithmeticExpressionGivenToConvert_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> ExpressionTree.convertToExpressionTree(invalidExpression1));
        assertThrows(IllegalArgumentException.class, () -> ExpressionTree.convertToExpressionTree(invalidExpression2));
        assertThrows(IllegalArgumentException.class, () -> ExpressionTree.convertToExpressionTree(invalidExpression3));
    }

    @Test
    void whenValidExpression1IsGivenToConvert_thenReturnsValidTree1() {
        LinkedBinaryTree<String> tree = ExpressionTree.convertToExpressionTree(validExpression1);
        assertEquals(validTree1, AbstractBinaryTree.parenthesize(tree, tree.root()));
    }

    @Test
    void whenValidExpression2IsGivenToConvert_thenReturnsValidTree2() {
        LinkedBinaryTree<String> tree = ExpressionTree.convertToExpressionTree(validExpression2);
        assertEquals(validTree2, AbstractBinaryTree.parenthesize(tree, tree.root()));
    }

    @Test
    void whenValidExpression3IsGivenToConvert_thenReturnsValidTree3() {
        LinkedBinaryTree<String> tree = ExpressionTree.convertToExpressionTree(validExpression3);
        assertEquals(validTree3, AbstractBinaryTree.parenthesize(tree, tree.root()));
    }
}