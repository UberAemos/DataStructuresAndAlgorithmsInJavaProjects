package projects.stacks_queues_dequeues.exception;

public class InssufficientShareException extends RuntimeException {
    private String message;

    public InssufficientShareException(int currentAmount, int requestedAmount) {
        message = String.format("Current amount %d is less than requested amount %d",
                currentAmount,
                requestedAmount);
    }

    public String getMessage() {
        return message;
    }
}
