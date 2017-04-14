package homework.proj12;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.14.2017
 * @dueDate 4.20.2017
 * @description Cipher Program
 */
public class TranspositionCipher implements MessageEncoder, MessageDecoder {

    // instance variables
    private final int n;

    // constructor
    public TranspositionCipher(int n) {
        if (n > 0) {
            this.n = n;
        } else { // end if
            throw new IllegalArgumentException(
                    "TranspositionCipher only accepts values greater than 0");
        } // end else
    } // end constructor

    @Override
    public String encode(String plainText) {
        StringBuilder encodedSB = new StringBuilder();
        encodedSB.append(plainText.toLowerCase());

        for (int j = 0; j < this.n; j++) {
            String currentString = encodedSB.toString();
            encodedSB.setLength(0);

            for (int i = 0; i < Math.round(currentString.length() / 2.0f); i++) {
                encodedSB.append(currentString.charAt(i));
                if (Math.round(currentString.length() / 2.0f) + i < currentString.length()) {
                    encodedSB.append(currentString.charAt(Math.round(currentString.length() / 2.0f) + i));
                } // end if
            } // end for
        } // end for
        return encodedSB.toString();
    }

    @Override
    public String decode(String cipherText) {
        StringBuilder decodedSB = new StringBuilder();
        decodedSB.append(cipherText);

        for (int j = 0; j < this.n; j++) {
            String currentString = decodedSB.toString();
            decodedSB.setLength(0);

            for (int i = 0; i < currentString.length(); i = i + 2) {
                decodedSB.append(currentString.charAt(i));
            } // end for

            for (int i = 1; i < currentString.length(); i = i + 2) {
                decodedSB.append(currentString.charAt(i));
            } // end for
        } // end for
        return decodedSB.toString();
    } // end decode

} // end class
