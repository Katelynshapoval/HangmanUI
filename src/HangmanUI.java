import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HangmanUI {
    // Constants
    private final HangmanLogic LOGIC;
//    private static final Color BG_COLOR = new Color(141, 69, 220);
    private static final Color BG_COLOR = Color.white;
    private int fails = 0;

    private JLabel imageLabel;
    private JLabel lettersGuessedLabel;
    private JPanel hangmanPanel;

    // Constructor
    public HangmanUI(HangmanLogic logic) {
        this.LOGIC = logic;

        // Main frame
        JFrame frame = new JFrame("MasterMind");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Ask for the word to guess
        requestSecret();

        // Guess panel
        frame.add(guessPanel(), BorderLayout.NORTH);

        // Image panel
        frame.add(hangmanStatusPanel(), BorderLayout.SOUTH);

        frame.setSize(400,600);

//        frame.pack();
        frame.setVisible(true);
    }

    public void requestSecret() {
        String secretWord = JOptionPane.showInputDialog(null, "Enter the word to guess:");
        LOGIC.setSecret(secretWord);
        System.out.println("User entered: " + secretWord);
    }

    public JPanel guessPanel() {
        JPanel guessPanel = new JPanel();
        guessPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        guessPanel.setBackground(BG_COLOR);

        // Input field (10 columns wide)
        JTextField inputField = new JTextField(10);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(80, 30));
        submitButton.setBackground(Color.WHITE);
        submitButton.setContentAreaFilled(true);
        submitButton.setBorderPainted(false);
        submitButton.setFocusPainted(false);

        submitButton.addActionListener(e -> {
            String currentGuess = inputField.getText();
            ArrayList <Integer> positionsGuessed = LOGIC.guessLetter(currentGuess);

            // If the letter is not in the word
            if (positionsGuessed.isEmpty()) {
                fails++;
            }
            lettersGuessedLabel.setText(LOGIC.getCurrentWordState());

            // Update hangman image
            String imagePath = "/stages/" + fails + ".png";
            imageLabel.setIcon(new ImageIcon(getClass().getResource(imagePath)));

            inputField.setText("");
        });

        // Add components
        guessPanel.add(inputField);
        guessPanel.add(submitButton);

        return guessPanel;
    }

    // Image panel for hangman stages
    public JPanel hangmanStatusPanel() {
        JPanel hangmanPanel = new JPanel(new BorderLayout());
        hangmanPanel.setBackground(BG_COLOR);

        // Image
        imageLabel = new JLabel(new ImageIcon(getClass().getResource("/stages/0.png")));

        // Status
        lettersGuessedLabel = new JLabel(LOGIC.getCurrentWordState());
        // Center the text
        lettersGuessedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Adding
        hangmanPanel.add(imageLabel, BorderLayout.SOUTH);
        hangmanPanel.add(lettersGuessedLabel, BorderLayout.NORTH);

        return hangmanPanel;
    }


}