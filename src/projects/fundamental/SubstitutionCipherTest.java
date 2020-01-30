package projects.fundamental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubstitutionCipherTest {
    private String testCipherKey = "FQRGEJNHKSBYVMCXZDOLTUAIPW";
    SubstitutionCipher testSubstitutionCipher = new SubstitutionCipher(testCipherKey);

    private String lowerCasePlainText = "defend the east wall of the castle";
    private String lowerCaseCipherText = "gejemg lhe efol afyy cj lhe rfolye";

    private String upperCasePlainText = "DEFEND THE EAST WALL OF THE CASTLE";
    private String upperCaseCipherText = "GEJEMG LHE EFOL AFYY CJ LHE RFOLYE";

    @Test
    void whenEmptyMessageIsGiven_returnsEmptyMessage() {
        assertEquals("", testSubstitutionCipher.cipher(""));
    }

    @Test
    void whenNonAlphabeticMessageIsGiven_returnsSameMessage() {
        assertEquals("!'+%&/()=?_ ", testSubstitutionCipher.cipher("!'+%&/()=?_ "));
    }

    @Test
    void whenGivenLowerCasePlainText_returnsLowerCaseCipherText() {
        assertEquals(lowerCaseCipherText, testSubstitutionCipher.cipher(lowerCasePlainText));
    }

    @Test
    void whenGivenUpperCasePlainText_returnsUpperCaseCipherText() {
        assertEquals(upperCaseCipherText, testSubstitutionCipher.cipher(upperCasePlainText));
    }
}