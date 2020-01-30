package projects.fundamental;

/**
 * Perform the Caesar cipher for English messages that include both upper- and lowercase characters.
 */
public class CaesarCipher {
    private final static int alphabetLength = 26;
    private final static int upperCaseASCIIStart = 65;
    private final static int lowerCaseASCIIStart = 97;

    public static String cipher(String message, int shift) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            char newChar;
            if (Character.isAlphabetic(currentChar)) {
                if (Character.isUpperCase(currentChar))
                    newChar = shiftChar(shift, currentChar, upperCaseASCIIStart);
                else newChar = (shiftChar(shift, currentChar, lowerCaseASCIIStart));
            } else newChar = currentChar;
            builder.append(newChar);
        }
        return builder.toString();
    }

    private static char shiftChar(int shift, char c, int upperCaseASCIIStart) {
        return (char) ((((int) c - upperCaseASCIIStart + shift) % alphabetLength) + upperCaseASCIIStart);
    }
}
