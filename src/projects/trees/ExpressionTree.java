package projects.trees;

import base.trees.BinaryTree;

/**
 * A program that converts an arithmetic expression to a binary expression tree, anc make related arithmetic operations
 * related to the tree
 */
public class ExpressionTree {

    /**
     * Converts the given expression to a Binary Expression Tree
     *
     * @param expression A fully parenthesized arithmetic expression
     * @return Binary Expression Tree
     * @throws IllegalArgumentException If the given expression is in an invalid format
     */
    public static BinaryTree convertToExpressionTree(String expression) throws IllegalArgumentException {
        if (!isExpression(expression)) throw new IllegalArgumentException("Invalid arithmetic expression format.");
        return null;
    }

    private static boolean isExpression(String expression) {
        return false;
    }
}
