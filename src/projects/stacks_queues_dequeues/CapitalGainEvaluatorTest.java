package projects.stacks_queues_dequeues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CapitalGainEvaluatorTest {

    private String buyTransaction1 = "buy 100 share(s) at $20 each";
    private String buyTransaction2 = "buy 20 share(s) at $24 each";
    private String buyTransaction3 = "buy 200 share(s) at $36 each";
    private String sellTransaction1 = "sell 150 share(s) at $30 each";

    @Test
    void whenValidBuyTransactionIsGivenToShareFactory_shareIsCreated() {
        assertEquals("Share{count=100, value=20}", CapitalGainEvaluator.Share.fromTransaction(buyTransaction1).toString());
        assertEquals("Share{count=20, value=24}", CapitalGainEvaluator.Share.fromTransaction(buyTransaction2).toString());
        assertEquals("Share{count=200, value=36}", CapitalGainEvaluator.Share.fromTransaction(buyTransaction3).toString());
    }

    @Test
    void whenInvalidBuyTransactionIsGivenToShareFactory_exceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> CapitalGainEvaluator.Share.fromTransaction(sellTransaction1));
    }

    @BeforeEach
    void init() {

    }

}