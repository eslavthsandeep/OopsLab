package Lab10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame {
    private int currentQuestionIndex = 0;
    private int score = 0;
    
    private JLabel questionLabel;
    private JRadioButton option1, option2, option3, option4;
    private ButtonGroup optionsGroup;
    private JButton nextButton, submitButton, finishButton;

    private String[] questions = {
        "What is the capital of France?",
        "Which planet is known as the Red Planet?",
        "What is the largest ocean on Earth?",
        "Who wrote 'To Kill a Mockingbird'?"
    };

    private String[][] options = {
        {"Paris", "London", "Berlin", "Madrid"},
        {"Earth", "Mars", "Jupiter", "Saturn"},
        {"Atlantic", "Indian", "Arctic", "Pacific"},
        {"Harper Lee", "J.K. Rowling", "Mark Twain", "Ernest Hemingway"}
    };

    private int[] correctAnswers = {0, 1, 3, 0}; // Index of the correct answer for each question

    public QuizApp() {
        setTitle("Quiz Application");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        questionLabel = new JLabel(questions[currentQuestionIndex], SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Create radio buttons for options
        option1 = new JRadioButton(options[currentQuestionIndex][0]);
        option2 = new JRadioButton(options[currentQuestionIndex][1]);
        option3 = new JRadioButton(options[currentQuestionIndex][2]);
        option4 = new JRadioButton(options[currentQuestionIndex][3]);

        // Group the radio buttons
        optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);

        // Panel to hold options
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        optionsPanel.add(option1);
        optionsPanel.add(option2);
        optionsPanel.add(option3);
        optionsPanel.add(option4);

        // Buttons
        nextButton = new JButton("Next");
        nextButton.setEnabled(true);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                if (currentQuestionIndex < questions.length - 1) {
                    currentQuestionIndex++;
                    updateQuestion();
                }
            }
        });

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                JOptionPane.showMessageDialog(null, "Your final score is: " + score + "/" + questions.length);
                System.exit(0); 
            }
        });

        finishButton = new JButton("Finish");
        finishButton.setEnabled(false);
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                JOptionPane.showMessageDialog(null, "Your final score is: " + score + "/" + questions.length);
                System.exit(0); 
            }
        });

        // Layout setup
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(nextButton);
        bottomPanel.add(submitButton);

        add(questionLabel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void updateQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionLabel.setText(questions[currentQuestionIndex]);
            option1.setText(options[currentQuestionIndex][0]);
            option2.setText(options[currentQuestionIndex][1]);
            option3.setText(options[currentQuestionIndex][2]);
            option4.setText(options[currentQuestionIndex][3]);
            optionsGroup.clearSelection();
        }
        if (currentQuestionIndex == questions.length - 1) {
            nextButton.setEnabled(false);
            finishButton.setEnabled(true);
        }
    }

    private void checkAnswer() {
        if (currentQuestionIndex < questions.length) {
            int correctAnswerIndex = correctAnswers[currentQuestionIndex];
            if (option1.isSelected() && correctAnswerIndex == 0) score++;
            if (option2.isSelected() && correctAnswerIndex == 1) score++;
            if (option3.isSelected() && correctAnswerIndex == 2) score++;
            if (option4.isSelected() && correctAnswerIndex == 3) score++;
        }
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}
