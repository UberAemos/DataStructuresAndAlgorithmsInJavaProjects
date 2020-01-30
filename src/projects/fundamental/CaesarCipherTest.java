package projects.fundamental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaesarCipherTest {

    // cipher method tests
    @Test
    void whenGivenEmpty_returnsEmpty() {
        assertEquals("", CaesarCipher.cipher("", 1));
    }

    @Test
    void whenShiftIsZero_returnsTheSameMessage() {
        assertEquals("ABC", CaesarCipher.cipher("ABC", 0));
    }

    @Test
    void whenNonAlphabeticMessageIsGiven_returnsTheSameMessage() {
        assertEquals("!'+%&/()=?_ ", CaesarCipher.cipher("!'+%&/()=?_ ", 1));
    }

    @Test
    void whenLowerCaseIsGiven_itShiftsAndKeepsInLowerCase() {
        assertEquals("dbgewhuai", CaesarCipher.cipher("zxcasdqwe", 30));
    }

    @Test
    void whenUpperCaseIsGiven_itShiftsAndKeepsInUpperCase() {
        assertEquals("DBGEWHKAI", CaesarCipher.cipher("ZXCASDGWE", 30));
    }
}