package projects.stacks_queues_dequeues;

import java.util.regex.Pattern;

public class CapitalGainEvaluator {
    /**
     * Describes the share stock of a company
     */
    public static class Share {
        private int amount;  // The stock amount
        private int value;  // Buy value of the stock
        final private static String transactionFormat = "buy \\d+ share\\(s\\) at \\$\\d+ each";

        public Share(int amount, int value) {
            this.amount = amount;
            this.value = value;
        }

        /**
         * Creates a Share object with the defined amount and value that is defined in the given buy transaction,
         * if the transaction is in the correct format.
         *
         * @param transaction A share buy transaction
         * @return Stock Share object in the amount and value of the transaction.
         */
        public static Share fromTransaction(String transaction) {
            if (isTransaction(transaction))
                throw new IllegalArgumentException(
                        "Illegal transaction format. " +
                                "Give a buy transaction in 'buy (amount) share(s) at $(value) each' format");
            String[] fragments = transaction.split(" ");
            int amount = Integer.parseInt(fragments[1]);
            int value = Integer.parseInt(fragments[4].substring(1));
            return new Share(amount, value);
        }

        private static boolean isTransaction(String transaction) {
            return !Pattern.matches(transactionFormat, transaction);
        }

        // Access Methods
        public int getAmount() {
            return amount;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Share{" +
                    "count=" + amount +
                    ", value=" + value +
                    '}';
        }
    }
}
