package projects.stacks_queues_dequeues;

import java.util.regex.Pattern;

public class CapitalGainEvaluator {
    // ------ Share implementation -------

    /**
     * Describes the share stock of a company
     */
    public static class Share {
        private int amount;  // The stock amount
        private int value;  // Buy value of the stock

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
            String[] fragments = transaction.split(" ");
            int amount = Integer.parseInt(fragments[1]);
            int value = Integer.parseInt(fragments[4].substring(1));
            return new Share(amount, value);
        }

        /**
         * Sells given amount of shares from the current share if current share has the required amount, else sells all
         * available amount within the current share
         *
         * @param share Sell amount and value for the current share
         * @return Capital gain from the sell transaction.
         */
        public int sellShare(Share share) {
            int sellAmount = Math.min(share.getAmount(), this.getAmount());
            this.subtract(sellAmount);
            share.subtract(sellAmount);
            return sellAmount * (share.getValue() - this.getValue());
        }

        private void subtract(int sellAmount) {
            this.amount = this.amount - sellAmount;
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
