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

    public int transact(String transaction) {
        if (isBuyTransaction(transaction)) return buy(transaction);
        else if (isSellTransaction(transaction)) return sell(transaction);
        else throw new IllegalArgumentException("Illegal transaction format.");
    }

    private int sell(String transaction) {
        Share sellShare = Share.fromTransaction(transaction);
        if (sellShare.getAmount() > totalShareAmount)
            throw new InssufficientShareException(totalShareAmount, sellShare.amount);
        totalShareAmount -= sellShare.amount;
        while (sellShare.amount > 0) {
            Share currentShare = shareQueue.first();
            capitalGain += currentShare.sellShare(sellShare);
            if (currentShare.amount == 0) shareQueue.dequeue();
        }
        return capitalGain;
    }

    private int buy(String transaction) {
        Share share = Share.fromTransaction(transaction);
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

    private static boolean isBuyTransaction(String transaction) {
        return Pattern.matches(buyTransactionFormat, transaction);
    }

    private static boolean isSellTransaction(String transaction) {
        return Pattern.matches(sellTransactionFormat, transaction);
    }
}
