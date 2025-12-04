import javax.swing.*;
import java.awt.*;

public class HangmanUI {
    // Constants
    private final HangmanLogic LOGIC;
    private final String SECRET_WORD;
    private static final Color BG_COLOR = new Color(141, 69, 220);

    private int fails = 0;

    // Constructor
    public HangmanUI(HangmanLogic logic) {
        this.LOGIC = logic;

        // Main frame
        JFrame frame = new JFrame("MasterMind");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Ask for the word to guess
        this.SECRET_WORD = JOptionPane.showInputDialog(null, "Enter the word to guess:");
        System.out.println("User entered: " + SECRET_WORD);

        // Guess panel
        frame.add(guessPanel());

        ImageIcon image = new ImageIcon(getClass().getResource("/stages/1.png"));
        JLabel label = new JLabel(image);
        frame.add(label);
        frame.setSize(400,600);

//        frame.pack();
        frame.setVisible(true);
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

        // Add components
        guessPanel.add(inputField);
        guessPanel.add(submitButton);

        return guessPanel;
    }

    public JPanel imagePanel() {
        JPanel imagePanel = new JPanel(new FlowLayout());
        return imagePanel;
    }

}