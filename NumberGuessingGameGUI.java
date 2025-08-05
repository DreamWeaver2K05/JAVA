import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessingGameGUI {

    private int numberToGuess;
    private int attempts;
    private int maxAttempts = 10;
    private int score = 0;
    private int roundsPlayed = 0;
    private final int minRange = 1;
    private final int maxRange = 100;

    private JFrame frame;
    private JTextField guessField;
    private JLabel messageLabel;
    private JLabel scoreLabel;
    private JLabel attemptsLabel;
    private JButton guessButton;

    public NumberGuessingGameGUI() {
        setupGame();
        createGUI();
    }

    private void setupGame() {
        numberToGuess = (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
        attempts = 0;
    }

    private void createGUI() {
        frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JLabel instructionLabel = new JLabel("Guess the number between " + minRange + " and " + maxRange + ":", JLabel.CENTER);
        panel.add(instructionLabel);

        guessField = new JTextField();
        panel.add(guessField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessButtonListener());
        panel.add(guessButton);

        messageLabel = new JLabel("Enter your guess above.", JLabel.CENTER);
        panel.add(messageLabel);

        attemptsLabel = new JLabel("Attempts left: " + (maxAttempts - attempts), JLabel.CENTER);
        panel.add(attemptsLabel);

        scoreLabel = new JLabel("Score: " + score, JLabel.CENTER);
        panel.add(scoreLabel);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void resetGame() {
        setupGame();
        messageLabel.setText("Enter your guess above.");
        attemptsLabel.setText("Attempts left: " + (maxAttempts - attempts));
        guessField.setText("");
        guessButton.setEnabled(true);
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = guessField.getText();

            try {
                int guess = Integer.parseInt(input);
                attempts++;

                if (guess < numberToGuess) {
                    messageLabel.setText("Too low!");
                } else if (guess > numberToGuess) {
                    messageLabel.setText("Too high!");
                } else {
                    messageLabel.setText("Correct! The number was " + numberToGuess + ".");
                    score += maxAttempts - attempts + 1;
                    guessButton.setEnabled(false);
                    int option = JOptionPane.showConfirmDialog(frame, "You guessed the number! Play again?", "Play Again", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        roundsPlayed++;
                        resetGame();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Thank you for playing! You played " + (roundsPlayed + 1) + " round(s) with a score of " + score + ".");
                        System.exit(0);
                    }
                }

                if (attempts >= maxAttempts && guess != numberToGuess) {
                    messageLabel.setText("Out of attempts! The number was " + numberToGuess + ".");
                    guessButton.setEnabled(false);
                    int option = JOptionPane.showConfirmDialog(frame, "Out of attempts! Play again?", "Play Again", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        roundsPlayed++;
                        resetGame();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Thank you for playing! You played " + (roundsPlayed + 1) + " round(s) with a score of " + score + ".");
                        System.exit(0);
                    }
                }

                attemptsLabel.setText("Attempts left: " + (maxAttempts - attempts));
                scoreLabel.setText("Score: " + score);
            } catch (NumberFormatException ex) {
                messageLabel.setText("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberGuessingGameGUI::new);
    }
}
