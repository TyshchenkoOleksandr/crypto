package constants;

public class CryptoAlphabet {
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String DIGITS = "0123456789";
    public static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~\\";

    public static final String FULL_ALPHABET =
            LOWERCASE_LETTERS +
                    UPPERCASE_LETTERS +
                    DIGITS +
                    SYMBOLS;

    public static char[] getAlphabetArray() {
        return FULL_ALPHABET.toCharArray();
    }
}
