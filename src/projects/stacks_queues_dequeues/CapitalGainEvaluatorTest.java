package projects.stacks_queues_dequeues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.stacks_queues_dequeues.exception.InssufficientShareException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CapitalGainEvaluatorTest {

    private String buyTransaction1 = "buy 100 share(s) at $20 each";
    private String buyTransaction2 = "buy 20 share(s) at $24 each";
    private String buyTransaction3 = "buy 200 share(s) at $36 each";
    private String sellTransaction1 = "sell 150 share(s) at $30 each";
    private String invalidTransaction = "feed one-fifty gazelle(s) at $30 each";

    private CapitalGainEvaluator.Share exampleShare;
    private CapitalGainEvaluator.Share largeSellShare;
    private CapitalGainEvaluator.Share lessSellShare;

    private CapitalGainEvaluator emptyGainEvaluator;

    @BeforeEach
    void init() {
        emptyGainEvaluator = new CapitalGainEvaluator();
        exampleShare = new CapitalGainEvaluator.Share(100, 20);
        lessSellShare = new CapitalGainEvaluator.Share(80, 30);
        largeSellShare = new CapitalGainEvaluator.Share(150, 10);
    }

    // ------ Share Tests ------
    @Test
    void whenValidBuyTransactionIsGivenToShareFactory_shareIsCreated() {
        assertEquals("Share{count=100, value=20}", CapitalGainEvaluator.Share.fromTransaction(buyTransaction1).toString());
        assertEquals("Share{count=20, value=24}", CapitalGainEvaluator.Share.fromTransaction(buyTransaction2).toString());
        assertEquals("Share{count=200, value=36}", CapitalGainEvaluator.Share.fromTransaction(buyTransaction3).toString());
    }

    @Test
    void whenSellAmountIsLargerThanShareAmount_subtractsSellShareAmount_currentShareAmountIsZero_returnsCapitalGain() {
        assertEquals(-1000, exampleShare.sellShare(largeSellShare));
        assertEquals(0, exampleShare.getAmount());
        assertEquals(50, largeSellShare.getAmount());
    }

    @Test
    void whenSellAmountIsLesserThanShareAmount_subtractsSellShareAmount_currentShareAmountIsZero_returnsCapitalGain() {
        assertEquals(800, exampleShare.sellShare(lessSellShare));
        assertEquals(20, exampleShare.getAmount());
        assertEquals(0, lessSellShare.getAmount());
    }

    @Test
    void whenInvalidTransactionIsGiven_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> emptyGainEvaluator.transact(invalidTransaction));
    }

    @Test
    void whenBuyTransactionIsGivenToEmptyEvaluator_returnsSharesTotalValueAsCapitalLoss() {
        assertEquals(0, emptyGainEvaluator.transact(buyTransaction1));
        assertEquals("CapitalGainEvaluator{" +
                        "shareQueue=[Share{count=100, value=20}]" +
                        ", capitalGain=0" +
                        ", totalShareAmount=100" +
                        '}',
                emptyGainEvaluator.toString());
    }

    @Test
    void whenBuyTransactionIsGivenToSingleShareEvaluator_returnsTotalValueAsCapitalLoss() {
        emptyGainEvaluator.transact(buyTransaction1);
        assertEquals(0, emptyGainEvaluator.transact(buyTransaction2));
        assertEquals("CapitalGainEvaluator{" +
                        "shareQueue=[Share{count=100, value=20}, Share{count=20, value=24}]" +
                        ", capitalGain=0" +
                        ", totalShareAmount=120" +
                        '}',
                emptyGainEvaluator.toString());
    }

    @Test
    void whenSellTransactionIsGivenWithInsufficientShareAmount_exceptionIsThrown() {
        emptyGainEvaluator.transact(buyTransaction1);
        assertThrows(InssufficientShareException.class, () -> emptyGainEvaluator.transact(sellTransaction1));
    }

    @Test
    void whenSellTransaction1IsGivenAfterBuyTransaction3_returnsCapitalLoss() {
        emptyGainEvaluator.transact(buyTransaction3);
        assertEquals(-900, emptyGainEvaluator.transact(sellTransaction1));
        assertEquals("CapitalGainEvaluator{" +
                        "shareQueue=[Share{count=50, value=36}]" +
                        ", capitalGain=-900" +
                        ", totalShareAmount=50" +
                        '}',
                emptyGainEvaluator.toString());
    }

    @Test
    void whenSellTransaction1IsGivenAfterBuyTransaction123_returnsCapitalGain() {
        emptyGainEvaluator.transact(buyTransaction1);
        emptyGainEvaluator.transact(buyTransaction2);
        emptyGainEvaluator.transact(buyTransaction3);
        assertEquals(940, emptyGainEvaluator.transact(sellTransaction1));
        assertEquals("CapitalGainEvaluator{" +
                        "shareQueue=[Share{count=170, value=36}]" +
                        ", capitalGain=940" +
                        ", totalShareAmount=170" +
                        '}',
                emptyGainEvaluator.toString());
    }
}