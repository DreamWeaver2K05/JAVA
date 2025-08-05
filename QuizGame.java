/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class QuizGame extends JFrame implements ActionListener {
    private JLabel questionLabel, timerLabel;
    private JRadioButton[] options;
    private ButtonGroup optionGroup;
    private JButton submitButton;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int timeLeft = 10; // 10 seconds for each question
    private Timer timer;

    // Questions, options, and answers
    private String[][] questions = {
        {"What is the capital of France?", "Paris", "Berlin", "Madrid", "Rome"},
        {"What is 5 + 3?", "6", "7", "8", "9"},
        {"Which planet is known as the Red Planet?", "Earth", "Mars", "Venus", "Jupiter"},
        {"What is the largest mammal?", "Elephant", "Blue Whale", "Shark", "Giraffe"},
        {"Who wrote 'Hamlet'?", "Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"}
    };

    private int[] correctAnswers = {0, 2, 1, 1, 1}; // Index of correct answers
    private ArrayList<String> userAnswers = new ArrayList<>();

    public QuizGame() {
        setTitle("Quiz Game");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Timer label
        timerLabel = new JLabel("Time left: " + timeLeft + " seconds", JLabel.RIGHT);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(timerLabel, BorderLayout.NORTH);

        // Question label
        questionLabel = new JLabel("", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(questionLabel, BorderLayout.CENTER);

        // Options panel
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        options = new JRadioButton[4];
        optionGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setFont(new Font("Arial", Font.PLAIN, 16));
            optionGroup.add(options[i]);
            optionsPanel.add(options[i]);
        }

        add(optionsPanel, BorderLayout.CENTER);

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton, BorderLayout.SOUTH);

        displayQuestion();
        startTimer();

        setVisible(true);
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.length) {
            String[] q = questions[currentQuestionIndex];
            questionLabel.setText(q[0]);

            for (int i = 0; i < 4; i++) {
                options[i].setText(q[i + 1]);
            }

            optionGroup.clearSelection();
        } else {
            endQuiz();
        }
    }

    private void startTimer() {
        timeLeft = 10;
        timerLabel.setText("Time left: " + timeLeft + " seconds");

        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time left: " + timeLeft + " seconds");

            if (timeLeft <= 0) {
                timer.stop();
                autoSubmitAnswer();
            }
        });

        timer.start();
    }

    private void autoSubmitAnswer() {
        userAnswers.add("No Answer");
        nextQuestion();
    }

    private void nextQuestion() {
        currentQuestionIndex++;
        displayQuestion();
        startTimer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            timer.stop();

            for (int i = 0; i < 4; i++) {
                if (options[i].isSelected()) {
                    userAnswers.add(options[i].getText());
                    if (i == correctAnswers[currentQuestionIndex]) {
                        score++;
                    }
                    break;
                }
            }

            nextQuestion();
        }
    }

    private void endQuiz() {
        StringBuilder resultSummary = new StringBuilder();

        for (int i = 0; i < questions.length; i++) {
            resultSummary.append("Q").append(i + 1).append(": ")
                .append(questions[i][0]).append("\n")
                .append("Your Answer: ").append(userAnswers.get(i)).append("\n")
                .append("Correct Answer: ").append(questions[i][correctAnswers[i] + 1]).append("\n\n");
        }

        JOptionPane.showMessageDialog(
            this,
            "Quiz Over!\nYour Score: " + score + " / " + questions.length + "\n\n" + resultSummary,
            "Quiz Results",
            JOptionPane.INFORMATION_MESSAGE
        );

        System.exit(0);
    }

    public static void main(String[] args) {
        new QuizGame();
    }
}*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class QuizApp extends JFrame implements ActionListener {
    private String[] questions = {
        "What is the capital of France?",
        "Who wrote 'Hamlet'?"
        // Add more questions here
    };
    private String[][] options = {
        {"Paris", "London", "Berlin", "Madrid"},
        {"Shakespeare", "Tolstoy", "Hemingway", "Austen"}
        // Add more options here
    };
    private String[] answers = {"Paris", "Shakespeare"};
    private int index = 0;
    private int score = 0;
    private JLabel questionLabel;
    private JRadioButton[] radioButtons = new JRadioButton[4];
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JButton nextButton;
    private JLabel timerLabel;
    private Timer timer;
    private int timeLimit = 10; // Time limit per question in seconds

    QuizApp() {
        setTitle("Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1));

        timerLabel = new JLabel();
        add(timerLabel);

        questionLabel = new JLabel();
        add(questionLabel);

        for (int i = 0; i < 4; i++) {
            radioButtons[i] = new JRadioButton();
            buttonGroup.add(radioButtons[i]);
            add(radioButtons[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton);

        displayQuestion();
        startTimer();
    }

    private void displayQuestion() {
        if (index < questions.length) {
            questionLabel.setText(questions[index]);
            for (int i = 0; i < 4; i++) {
                radioButtons[i].setText(options[index][i]);
            }
        } else {
            showResult();
        }
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            int timeRemaining = timeLimit;

            @Override
            public void actionPerformed(ActionEvent e) {
                timerLabel.setText("Time remaining: " + timeRemaining + " seconds");
                timeRemaining--;
                if (timeRemaining < 0) {
                    timer.stop();
                    if (index < questions.length) {
                        checkAnswer();
                        index++;
                        displayQuestion();
                        timeRemaining = timeLimit;
                        startTimer();
                    }
                }
            }
        });
        timer.start();
    }

    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (radioButtons[i].isSelected() && radioButtons[i].getText().equals(answers[index])) {
                score++;
            }
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Your final score is: " + score);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (index < questions.length) {
            checkAnswer();
            index++;
            displayQuestion();
            timer.stop();
            startTimer();
        }
    }

    public static void main(String[] args) {
        new QuizApp().setVisible(true);
    }
}

