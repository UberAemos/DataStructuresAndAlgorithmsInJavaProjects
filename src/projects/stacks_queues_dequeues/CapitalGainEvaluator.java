package projects.stacks_queues_dequeues;

import base.stacks_queues_dequeues.LinkedQueue;
import projects.stacks_queues_dequeues.exception.InssufficientShareException;

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
    // ------ Share implementation end-------

    private LinkedQueue<Share> shareQueue = new LinkedQueue<>();
    private int capitalGain = 0;
    private int totalShareAmount = 0;

    final private static String buyTransactionFormat = "buy \\d+ share\\(s\\) at \\$\\d+ each";
    final private static String sellTransactionFormat = "sell \\d+ share\\(s\\) at \\$\\d+ each";
    final private static String transactionFormat = "(buy|sell) \\d+ share\\(s\\) at \\$\\d+ each";

    /**
     * Attempts to make a buy / sell transaction from the given transaction text
     *
     * @param transaction transaction text that includes transaction type, share amount and value.
     * @return current capital gain / loss from the sequence of transactions.
     */
    public int transact(String transaction) {
        if (isTransaction(transaction)) {
            Share share = Share.fromTransaction(transaction);
            if (transaction.contains("buy")) return buy(share);
            else return sell(share);
        } else throw new IllegalArgumentException("Illegal transaction format.");
    }

    /**
     * Sells given amount of shares at the given value
     *
     * @param share Defines the sell amount and value of the shares
     * @return Current capital gain / loss after the transaction
     */
    private int sell(Share share) {
        if (share.getAmount() > totalShareAmount)
            throw new InssufficientShareException(totalShareAmount, share.amount);
        totalShareAmount -= share.amount;
        while (share.amount > 0) {
            Share currentShare = shareQueue.first();
            capitalGain += currentShare.sellShare(share);
            if (currentShare.amount == 0) shareQueue.dequeue();
        }
        return capitalGain;
    }

    /**
     * Buys given amount of shares at the given value
     *
     * @param share Defines the amount and value of shares to be bought
     * @return Current capital gain / loss after the transaction
     */
    private int buy(Share share) {
        shareQueue.enqueue(share);
        totalShareAmount += share.amount;
        return capitalGain;
    }

    public String toString() {
        return "CapitalGainEvaluator{" +
                "shareQueue=" + shareQueue +
                ", capitalGain=" + capitalGain +
                ", totalShareAmount=" + totalShareAmount +
                '}';
    }

    /**
     * Checks the given transaction text against the defined transaction format
     *
     * @param transaction The transaction text to be checked.
     * @return true if the transaction matches the format
     */
    private static boolean isTransaction(String transaction) {
        return Pattern.matches(transactionFormat, transaction);
    }
}
