import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Question {
    String question, optionA, optionB, optionC, optionD, correctAnswer;

    public Question(String q, String a, String b, String c, String d, String correct) {
        question = q;
        optionA = a;
        optionB = b;
        optionC = c;
        optionD = d;
        correctAnswer = correct;
    }
}

public class CurrentAffairsQuiz2025 extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel questionLabel, scoreLabel;
    private JButton optionA, optionB, optionC, optionD;
    private JButton nextButton, backButton;
    private int currentQuestionIndex = 0, score = 0, levelStartIndex = 0;
    private List<Question> questions = new ArrayList<>();

    public CurrentAffairsQuiz2025() {
        setTitle("Current Affairs Quiz 2025");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Start Panel
        JPanel startPanel = new JPanel(new GridLayout(5, 1, 20, 20));
        startPanel.setBackground(new Color(25, 25, 112));

        JLabel title = new JLabel("⚡ Current Affairs Quiz 2025 ⚡", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(Color.WHITE);

        JButton easyButton = createLevelButton("Easy", new Color(76, 175, 80), "easy");
        JButton mediumButton = createLevelButton("Medium", new Color(255, 152, 0), "medium");
        JButton hardButton = createLevelButton("Hard", new Color(244, 67, 54), "hard");

        backButton = new JButton("⬅ Back");
        backButton.setBackground(new Color(100, 100, 100));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "start"));

        startPanel.add(title);
        startPanel.add(easyButton);
        startPanel.add(mediumButton);
        startPanel.add(hardButton);
        startPanel.add(backButton);

        // Quiz Panel
        JPanel quizPanel = new JPanel(new BorderLayout());
        quizPanel.setBackground(new Color(18, 18, 18));

        questionLabel = new JLabel("Question appears here", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 22));
        questionLabel.setForeground(Color.WHITE);

        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scoreLabel.setForeground(Color.YELLOW);

        optionA = createOptionButton();
        optionB = createOptionButton();
        optionC = createOptionButton();
        optionD = createOptionButton();

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 5, 3));
        optionsPanel.setBackground(new Color(18, 18, 18));
        optionsPanel.add(optionA);
        optionsPanel.add(optionB);
        optionsPanel.add(optionC);
        optionsPanel.add(optionD);

        nextButton = new JButton("➡ Next");
        nextButton.setBackground(new Color(33, 150, 243));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Arial", Font.BOLD, 18));
        nextButton.setEnabled(false);
        nextButton.addActionListener(e -> {
            currentQuestionIndex++;
            showQuestion();
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(18, 18, 18));
        topPanel.add(questionLabel, BorderLayout.CENTER);
        topPanel.add(scoreLabel, BorderLayout.SOUTH);

        quizPanel.add(topPanel, BorderLayout.NORTH);
        quizPanel.add(optionsPanel, BorderLayout.CENTER);
        quizPanel.add(nextButton, BorderLayout.SOUTH);

        mainPanel.add(startPanel, "start");
        mainPanel.add(quizPanel, "quiz");
        add(mainPanel);

        loadQuestions();
        cardLayout.show(mainPanel, "start");
    }

    private JButton createLevelButton(String text, Color color, String level) {
        JButton btn = new JButton(text);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.addActionListener(e -> startQuiz(level));
        return btn;
    }

    private JButton createOptionButton() {
        JButton btn = new JButton();
        btn.setFont(new Font("Arial", Font.BOLD, 18));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(33, 33, 33));
        btn.setFocusPainted(false);
        btn.setMargin(new Insets(8, 12, 8, 12));
        btn.addActionListener(e -> handleAnswer(btn));
        return btn;
    }

    private void loadQuestions() {
        // === EASY (15) ===
        questions.add(new Question("Who won the 2025 Australian Open Men's Singles title?", "Novak Djokovic", "Rafael Nadal", "Jannik Sinner", "Carlos Alcaraz", "Carlos Alcaraz"));
        questions.add(new Question("Who won the 2025 FIFA Women's World Cup?", "Germany", "USA", "Brazil", "Spain", "USA"));
        questions.add(new Question("Who won the 2025 Nobel Peace Prize?", "Greta Thunberg", "Malala Yousafzai", "UNICEF", "Joe Biden", "Greta Thunberg"));
        questions.add(new Question("Which country launched the world's first 6G satellite?", "China", "USA", "India", "Russia", "China"));
        questions.add(new Question("Which Indian city hosted the 2025 G20 Summit?", "Mumbai", "Delhi", "Hyderabad", "Bangalore", "Mumbai"));
        questions.add(new Question("Which country became the first to achieve carbon neutrality?", "Bhutan", "Norway", "Sweden", "Japan", "Bhutan"));
        questions.add(new Question("Which country achieved 100% renewable energy usage?", "Iceland", "Denmark", "Norway", "Germany", "Iceland"));
        questions.add(new Question("Which country hosted the 2025 World Athletics Championships?", "United Kingdom", "USA", "France", "China", "United Kingdom"));
        questions.add(new Question("Which Indian state launched 'Digital Education for All'?", "Kerala", "Tamil Nadu", "Karnataka", "Delhi", "Kerala"));
        questions.add(new Question("Which Indian city achieved zero waste status?", "Indore", "Surat", "Bhopal", "Chennai", "Indore"));
        questions.add(new Question("Which country launched the first commercial space hotel?", "Japan", "USA", "China", "Russia", "Japan"));
        questions.add(new Question("Which country achieved 100% EV adoption?", "Norway", "Sweden", "Germany", "Netherlands", "Norway"));
        questions.add(new Question("Which Indian city hosted WEF 2025?", "New Delhi", "Mumbai", "Bangalore", "Chennai", "New Delhi"));
        questions.add(new Question("Which Indian state launched 'Smart Healthcare for All'?", "Tamil Nadu", "Kerala", "Punjab", "Gujarat", "Tamil Nadu"));
        questions.add(new Question("Who became India's first female Army combat leader?", "Lt Gen Shubhangi Swaroop", "Lt Gen Madhuri Kanitkar", "Lt Gen Priya Singh", "Lt Gen Anjali Sharma", "Lt Gen Shubhangi Swaroop"));

        // === MEDIUM (15) ===
        questions.add(new Question("Which state launched 'Ladki Bahin' scheme?", "Maharashtra", "UP", "Rajasthan", "Gujarat", "Maharashtra"));
        questions.add(new Question("Which city achieved zero maternal mortality?", "Puducherry", "Indore", "Kochi", "Delhi", "Puducherry"));
        questions.add(new Question("Which country established a permanent lunar base?", "Russia", "USA", "China", "India", "Russia"));
        questions.add(new Question("Which state launched 'Nischay Swayam Sahayata Yojana'?", "Bihar", "UP", "Jharkhand", "Odisha", "Bihar"));
        questions.add(new Question("Which disease hit headlines in Jan 2025?", "Tularemia", "Malaria", "Ebola", "Cholera", "Tularemia"));
        questions.add(new Question("Which country hosted UN Climate Change Conference 2025?", "Brazil", "USA", "France", "Germany", "Brazil"));
        questions.add(new Question("Which country achieved 100% EV adoption?", "Norway", "Japan", "China", "France", "Norway"));
        questions.add(new Question("Which country launched space hotel?", "Japan", "Russia", "USA", "India", "Japan"));
        questions.add(new Question("Which city hosted G20 2025?", "Mumbai", "Delhi", "Hyderabad", "Bangalore", "Mumbai"));
        questions.add(new Question("Which city hosted WEF 2025?", "New Delhi", "Mumbai", "Hyderabad", "Kolkata", "New Delhi"));
        questions.add(new Question("Which state launched 'Digital Education for All'?", "Kerala", "UP", "Delhi", "Rajasthan", "Kerala"));
        questions.add(new Question("Which state launched 'Smart Healthcare for All'?", "Tamil Nadu", "Kerala", "Punjab", "Bihar", "Tamil Nadu"));
        questions.add(new Question("Which state launched 'Ladki Bahin' scheme?", "Maharashtra", "UP", "MP", "Gujarat", "Maharashtra"));
        questions.add(new Question("Which city achieved zero maternal mortality?", "Puducherry", "Mumbai", "Kolkata", "Chennai", "Puducherry"));
        questions.add(new Question("Which state launched 'Nischay Swayam Sahayata Yojana'?", "Bihar", "UP", "Odisha", "Jharkhand", "Bihar"));

        // === HARD (15) ===
        questions.add(new Question("Which country achieved carbon neutrality?", "Bhutan", "Norway", "Japan", "Sweden", "Bhutan"));
        questions.add(new Question("Which country launched 6G satellite?", "China", "India", "USA", "Russia", "China"));
        questions.add(new Question("Which country hosted Athletics 2025?", "United Kingdom", "USA", "Germany", "France", "United Kingdom"));
        questions.add(new Question("Which state launched 'Nischay Swayam Sahayata Yojana'?", "Bihar", "UP", "MP", "Odisha", "Bihar"));
        questions.add(new Question("Which city hosted WEF 2025?", "New Delhi", "Mumbai", "Hyderabad", "Kolkata", "New Delhi"));
        questions.add(new Question("Which state launched 'Smart Healthcare for All'?", "Tamil Nadu", "Kerala", "Punjab", "Maharashtra", "Tamil Nadu"));
        questions.add(new Question("Which country achieved 100% renewable energy?", "Iceland", "Norway", "Germany", "Sweden", "Iceland"));
        questions.add(new Question("Which city achieved zero waste?", "Indore", "Bhopal", "Surat", "Nagpur", "Indore"));
        questions.add(new Question("Which country launched space hotel?", "Japan", "China", "USA", "India", "Japan"));
        questions.add(new Question("Which city hosted G20 2025?", "Mumbai", "Delhi", "Kolkata", "Bangalore", "Mumbai"));
        questions.add(new Question("Which city achieved zero maternal mortality?", "Puducherry", "Delhi", "Mumbai", "Kolkata", "Puducherry"));
        questions.add(new Question("Who was first female combat Army leader?", "Lt Gen Shubhangi Swaroop", "Lt Gen Madhuri Kanitkar", "Lt Gen Priya Singh", "Lt Gen Anjali Sharma", "Lt Gen Shubhangi Swaroop"));
        questions.add(new Question("Which disease was in news Jan 2025?", "Tularemia", "Ebola", "Covid", "SARS", "Tularemia"));
        questions.add(new Question("Which country set up lunar base?", "Russia", "USA", "India", "China", "Russia"));
        questions.add(new Question("Which country hosted UN Climate 2025?", "Brazil", "France", "Germany", "UK", "Brazil"));
    }

    private void startQuiz(String level) {
        score = 0;
        scoreLabel.setText("Score: 0");

        levelStartIndex = switch (level) {
            case "easy" -> 0;
            case "medium" -> 15;
            case "hard" -> 30;
            default -> 0;
        };
        currentQuestionIndex = levelStartIndex;

        showQuestion();
        cardLayout.show(mainPanel, "quiz");
    }

    private void showQuestion() {
        nextButton.setEnabled(false);

        // End quiz after 15 questions per level
        if (currentQuestionIndex >= levelStartIndex + 15) {
            JOptionPane.showMessageDialog(this,
                    "🎉 Congratulations! You completed the quiz!\nYour Total Score: " + score + "/15",
                    "Quiz Finished", JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(mainPanel, "start");
            return;
        }

        Question q = questions.get(currentQuestionIndex);
        questionLabel.setText((currentQuestionIndex - levelStartIndex + 1) + ". " + q.question);

        List<String> opts = new ArrayList<>(Arrays.asList(q.optionA, q.optionB, q.optionC, q.optionD));
        Collections.shuffle(opts);

        optionA.setText(opts.get(0));
        optionB.setText(opts.get(1));
        optionC.setText(opts.get(2));
        optionD.setText(opts.get(3));

        Color defaultBg = new Color(33, 33, 33);
        optionA.setBackground(defaultBg);
        optionB.setBackground(defaultBg);
        optionC.setBackground(defaultBg);
        optionD.setBackground(defaultBg);

        optionA.setEnabled(true);
        optionB.setEnabled(true);
        optionC.setEnabled(true);
        optionD.setEnabled(true);
    }

    private void handleAnswer(JButton selectedBtn) {
        Question q = questions.get(currentQuestionIndex);
        String selected = selectedBtn.getText();

        optionA.setEnabled(false);
        optionB.setEnabled(false);
        optionC.setEnabled(false);
        optionD.setEnabled(false);

        if (selected.equals(q.correctAnswer)) {
            selectedBtn.setBackground(Color.GREEN);
            score++;
            scoreLabel.setText("Score: " + score);
        } else {
            selectedBtn.setBackground(Color.RED);
            if (optionA.getText().equals(q.correctAnswer)) optionA.setBackground(Color.GREEN);
            if (optionB.getText().equals(q.correctAnswer)) optionB.setBackground(Color.GREEN);
            if (optionC.getText().equals(q.correctAnswer)) optionC.setBackground(Color.GREEN);
            if (optionD.getText().equals(q.correctAnswer)) optionD.setBackground(Color.GREEN);
        }

        nextButton.setEnabled(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CurrentAffairsQuiz2025GUI().setVisible(true));
    }
}
