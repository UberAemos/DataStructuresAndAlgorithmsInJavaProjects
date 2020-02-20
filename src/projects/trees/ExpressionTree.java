package projects.trees;

import base.trees.LinkedBinaryTree;
import base.trees.Position;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * A program that converts an arithmetic expression to a binary expression tree, anc make related arithmetic operations
 * related to the tree
 */
public class ExpressionTree {

    final private static String expressionFormat = "(((\\(.+\\))|\\d+)\\s[+*\\-/]\\s((\\(.+\\))|\\d+))";
    final private static List<String> arithmeticExpressionSign = Arrays.asList("+", "-", "*", "/");

    /**
     * Converts the given expression to a Binary Expression Tree
     * @param expression A fully parenthesized arithmetic expression
     * @return Binary Expression Tree
     * @throws IllegalArgumentException If the given expression is in an invalid format
     */
    public static LinkedBinaryTree<String> convertToExpressionTree(String expression) throws IllegalArgumentException {
        LinkedBinaryTree<String> expressionTree = new LinkedBinaryTree<>();
        expressionTree.addRoot(expression);
        return convertToExpressionNode(expressionTree.root(), expressionTree);
    }

    /**
     * Evaluates the expressionTree starting from the given position
     *
     * @param position Position to start the evaluation, position should be an arithmetic sign
     * @param expressionTree Arithmetic expression tree to evaluate
     * @return The numeric result of the arithmetic operation
     * @throws IllegalArgumentException If the given position is not an arithmetic operation sign
     */
    public static int evaluateExpressionTree(Position<String> position, LinkedBinaryTree<String> expressionTree)
            throws IllegalArgumentException {
        if (!isSign(position.getElement())) throw new IllegalArgumentException(position.getElement() +
                " is not a valid arithmetic operation sign.");
        return evaluateExpressionNode(position, expressionTree);
    }

    /**
     * Evaluates the arithmetic expression with arguments as left and right child if the given position is a sign, else
     * returns the numeric expression
     *
     * @param position       Current position to evaluate
     * @param expressionTree Arithmetic expression tree
     * @return A new arithmetic expression if the current position is a sign else returns the numeric value
     */
    private static int evaluateExpressionNode(Position<String> position, LinkedBinaryTree<String> expressionTree) {
        String element = position.getElement();
        if (isNumeric(element)) return Integer.parseInt(element);
        else if (isSign(element)) {
            Position<String> left = expressionTree.left(position);
            Position<String> right = expressionTree.right(position);
            switch (element) {
                case "+":
                    return evaluateExpressionNode(left, expressionTree) + evaluateExpressionNode(right, expressionTree);
                case "-":
                    return evaluateExpressionNode(left, expressionTree) - evaluateExpressionNode(right, expressionTree);
                case "*":
                    return evaluateExpressionNode(left, expressionTree) * evaluateExpressionNode(right, expressionTree);
                default:
                    return evaluateExpressionNode(left, expressionTree) / evaluateExpressionNode(right, expressionTree);
            }
        } else throw new IllegalArgumentException(element + " is not a valid arithmetic expression sign.");
    }

    private static boolean isSign(String element) {
        return arithmeticExpressionSign.contains(element);
    }

    /**
     * Checks the given expression, assigns the current arithmetic operator to the current position and adds left and right
     * arguments to the corresponding children node, until a number remains
     *
     * @param position       Current position to check arithmetic expression
     * @param expressionTree Arithmetic expression tree that contains the current position
     * @return Updated state of the arithmetic expression tree if only an integer remains within the expression
     */
    private static LinkedBinaryTree<String> convertToExpressionNode(Position<String> position,
                                                                    LinkedBinaryTree<String> expressionTree) {
        if (isNumeric(position.getElement())) return expressionTree;
        String expression = position.getElement();
        expression = expression.substring(1, expression.length() - 1);
        if (!isExpression(expression))
            throw new IllegalArgumentException(expression + " is not in a valid arithmetic expression format.");
        int arithmeticOperationIndex = findCurrentArithmeticOperationIndex(expression);
        expressionTree.set(position, Character.toString(expression.charAt(arithmeticOperationIndex)));
        expressionTree.addLeft(position, expression.substring(0, arithmeticOperationIndex - 1));
        expressionTree.addRight(position, expression.substring(arithmeticOperationIndex + 2));
        convertToExpressionNode(expressionTree.left(position), expressionTree);
        return convertToExpressionNode(expressionTree.right(position), expressionTree);
    }

    /**
     * Finds the arithmetic operation's index for the outermost expression
     *
     * @param expression Arithmetic expression in text
     * @return Operation sign index of the outermost expression
     */
    private static int findCurrentArithmeticOperationIndex(String expression) {
        int parenthesisStack = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') parenthesisStack++;
            else if (expression.charAt(i) == ')') parenthesisStack--;
            else if (isSign(Character.toString(expression.charAt(i))) && parenthesisStack == 0) return i;
        }
        return 0;
    }

    /**
     * Checks if the given expression is an integer
     *
     * @param expression Arithmetic expression to check
     * @return True if the expression is only numeric.
     */
    private static boolean isNumeric(String expression) {
        if (expression == null) return false;
        try {
            Integer.parseInt(expression);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the given expression is in the format (a + b) or ((a + b) + c) etc.
     *
     * @param expression Given arithmetic expression
     * @return true if the arithmetic expression format is correct
     */
    private static boolean isExpression(String expression) {
        return Pattern.matches(expressionFormat, expression);
    }

}
