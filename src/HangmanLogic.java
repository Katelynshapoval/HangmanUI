import java.util.ArrayList;

public class HangmanLogic {
    private final int WORD_LENGTH;
    private String SECRET;
    private String currentWordState;

    // Constructor
    public HangmanLogic(int wordLength) {
        this.WORD_LENGTH = wordLength;
    }

    // Get the secret word length
    public int getWordLength() {
        return WORD_LENGTH;
    }

    // Check if the letter provided is in the secret word
    public ArrayList<Integer> guessLetter(String letter) {
        // Guessed positions
        ArrayList<Integer> positions = new ArrayList<>();
        // Letter guessed
        char guess = letter.charAt(0);
        // Changing the guess state
        StringBuilder newState = new StringBuilder();

        for (int i = 0; i < SECRET.length(); i++) {
            char secretChar = SECRET.charAt(i);
            char currentChar = currentWordState.charAt(i * 2); // ignore spaces

            // If the user guessed correctly
            if (secretChar == guess) {
                positions.add(i);
                newState.append(secretChar);
            } else {
                newState.append(currentChar); // keep previously revealed letter or _
            }
            newState.append(" ");
        }

        currentWordState = newState.toString();
        return positions;
    }

    // Set the value of a secret word
    public void setSecret(String word) {
        this.SECRET = word;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append("_ ");
        }

        currentWordState = sb.toString();
    }


    // Get the secret word
    public String getSecret() {
        return SECRET;
    }

    public String getCurrentWordState() {
        return currentWordState;
    }
}
