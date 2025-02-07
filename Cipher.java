// This class is used for encrypting or decrypting strings using character mapping
public class Cipher {
    // Strings for keeping the alphabets, one for the original letters and the other for the encrypted ones
    // encryption involves mapping from original to cipher, for each letter we locate the character in the
    // original string and replace it with the cipher alphabet letter at the same position
    public static final String ORIGINAL_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String CIPHER_ALPHABET = "dfxyhrklvwuasgimnojpqetbcz";

    public String encrypt(String inputString) {
        // Output string will be collected in this variable, one char at a time
        String outputString = "";

        // For all chars in the input string
        for (int i = 0; i < inputString.length(); i++) {
            // Append the encrypted version of the char to the output string
            outputString += replaceChar(inputString.charAt(i), true);
        }

        return outputString;
    }

    public String decrypt(String inputString) {
        // Output string will be collected in this variable, one char at a time
        String outputString = "";

        // For all chars in the input string
        for (int i = 0; i < inputString.length(); i++) {
            // Append the decrypted version of the char to the output string
            outputString += replaceChar(inputString.charAt(i), false);
        }

        return outputString;
    }

    // Replaces the given input char based on the given isEncrypt variable
    // if isEncrypt == true -> original to encrypted
    // if isEncrypt == false -> encrypted to original
    // Works only when the input char is included in our alphabet variables
    // Should not replace symbols or upper-case letters, return input char in those cases
    private char replaceChar(char inputChar, boolean isEncrypt) {
        if (isEncrypt) {
            int index = ORIGINAL_ALPHABET.indexOf(inputChar);
            if (index != -1) {
                return CIPHER_ALPHABET.charAt(index);
            }
        } else {
            int index = CIPHER_ALPHABET.indexOf(inputChar);
            if (index != -1) {
                return ORIGINAL_ALPHABET.charAt(index);
            }
        }
        // If the character is not found in our alphabets, return it as is
        return inputChar;
    }
}
