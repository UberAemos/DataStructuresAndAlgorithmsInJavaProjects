package projects.stacks_queues_dequeues;

import base.stacks_queues_dequeues.LinkedStack;
import base.stacks_queues_dequeues.Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * A program that can input an expression in postfix notation and output its value.
 */
public class PostfixEvaluator {
    // Valid operations for Postfix expressions
    final static List<String> operations = Arrays.asList("+", "-", "*", "/");

    /**
     * Evaluates a postfix expression
     *
     * @param expression Expression in postfix format
     * @return The result of postfix expression
     */
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new LinkedStack<>();
        String currentValue;

        while (!expression.isEmpty()) {
            int nextExpressionStart = nextValueOrOperationIndex(expression);
            currentValue = expression.substring(0, nextExpressionStart).trim();
            expression = expression.substring(nextExpressionStart);

            if (isMathSign(currentValue)) {
                int secondVar = Optional.ofNullable(stack.pop()).orElseThrow(IllegalArgumentException::new);
                int firstVar = Optional.ofNullable(stack.pop()).orElseThrow(IllegalArgumentException::new);

                stack.push(evaluateExpression(firstVar, secondVar, currentValue));
            } else {
                try {
                    stack.push(Integer.parseInt(currentValue));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid expression format");
                }
            }
        }
        if (stack.isEmpty() || stack.size() > 1) throw new IllegalArgumentException("Invalid expression format");
        return stack.pop();
    }

    /**
     * Evaluates a two argument math expression according to the given math operation
     *
     * @param firstVar     First value of the operation
     * @param secondVar    Second value of the operation
     * @param currentValue Math operation sign
     * @return The result of the operation
     */
    private static int evaluateExpression(int firstVar, int secondVar, String currentValue) {
        switch (currentValue) {
            case "+":
                return firstVar + secondVar;
            case "-":
                return firstVar - secondVar;
            case "*":
                return firstVar * secondVar;
            default:
                return firstVar / secondVar;
        }
    }

    /**
     * Finds the next integer value or math operation index within the expression
     *
     * @param expression Expression in postfix format
     * @return The index of the next integer value or math operation sign
     */
    private static int nextValueOrOperationIndex(String expression) {
        return (expression.contains(" ")) ? expression.indexOf(" ") + 1 : expression.length();
    }

    /**
     * Checks if the given argument is a valid math operation within this class
     *
     * @param currentChar Part of the postfix expression to be checked
     * @return true if the given argument is a valid math operation for this class
     */
    private static boolean isMathSign(String currentChar) {
        return operations.contains(currentChar);
    }
}
