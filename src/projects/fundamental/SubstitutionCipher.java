package projects.fundamental;

public class SubstitutionCipher {
    private final static int upperCaseASCIIStart = 65;
    private String cipherKey;

    public SubstitutionCipher(String cipherKey) {
        if (cipherKey.length() != 26) throw new IllegalArgumentException("Decipher key should contain all alphabet");
        else {
            for (int i = 0; i < 26; i++) {
                if (Character.isLowerCase(cipherKey.charAt(i)))
                    throw new IllegalArgumentException("Decipher key indices should all be uppercase");
            }
        }
        this.cipherKey = cipherKey;
    }

    /**
     * Ciphers the given message by mapping their index in decipher key to the alphabet
     */
    public String cipher(String plaintext) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            if (Character.isAlphabetic(currentChar)) {
                boolean isLowerCase = Character.isLowerCase(currentChar);
                int keyIndex = ((int) Character.toUpperCase(currentChar)) - 65;
                char cipherChar = cipherKey.charAt(keyIndex);
                cipherChar = isLowerCase ? Character.toLowerCase(cipherChar) : cipherChar;
                builder.append(cipherChar);
            } else builder.append(currentChar);
        }
        return builder.toString();
    }

    private int getKeyIndex(char currentChar) {
        return cipherKey.indexOf(Character.toUpperCase(currentChar));
    }
}
