import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int wordLength = 5;

        // Create logic
        HangmanLogic logic = new HangmanLogic(wordLength);

        // Create UI
        SwingUtilities.invokeLater(() -> {
            new HangmanUI(logic);
        });
    }
}