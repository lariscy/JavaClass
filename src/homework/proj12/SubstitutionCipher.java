package homework.proj12;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.14.2017
 * @dueDate 4.20.2017
 * @description Cipher Program
 */
public class SubstitutionCipher implements MessageEncoder, MessageDecoder {

    // constants
    private static final int NUM_LETTERS_IN_ALPHABET = 26;

    // instance variables
    private final int shiftBy;

    // constructor
    public SubstitutionCipher(int shiftBy) {
        if (shiftBy > 0 && shiftBy < SubstitutionCipher.NUM_LETTERS_IN_ALPHABET) {
            this.shiftBy = shiftBy;
        } else { // end if
            throw new IllegalArgumentException(
                    "SubstitutionCipher only accepts values in the range of 1 "
                    + " - " + (SubstitutionCipher.NUM_LETTERS_IN_ALPHABET - 1));
        } // end else
    } // end constructor

    @Override
    public String encode(String plainText) {
        StringBuilder encodedSB = new StringBuilder();
        for (char c : plainText.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                encodedSB.append((char) ((c - 'a' + this.shiftBy) % SubstitutionCipher.NUM_LETTERS_IN_ALPHABET + 'a'));
            } else { // end if
                encodedSB.append(c);
            } // end else
        } // end for
        return encodedSB.toString();
    } // end encode

    @Override
    public String decode(String cipherText) {
        StringBuilder decodedSB = new StringBuilder();
        for (char c : cipherText.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                decodedSB.append((char) ((c - 'a' + SubstitutionCipher.NUM_LETTERS_IN_ALPHABET - this.shiftBy) % SubstitutionCipher.NUM_LETTERS_IN_ALPHABET + 'a'));
            } else { // end if
                decodedSB.append(c);
            } // end else
        } // end for
        return decodedSB.toString();
    } // end decode

} // end class
