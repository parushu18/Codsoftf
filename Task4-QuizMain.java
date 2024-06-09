import java.util.Scanner;

class QuizQuestion {
    private String question;
    private String[] options;
    private char correctAnswer;

    public QuizQuestion(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}

class Timer {
    private int timeLimit; // Time limit in seconds

    public Timer(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void startTimer() {
        // Implement timer logic using threads
    }

    public void stopTimer() {
        // Stop timer
    }
}

class QuestionDisplay {
    public static void displayQuestion(QuizQuestion question) {
        System.out.println(question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((char) ('A' + i) + ") " + options[i]);
        }
    }

    public static char getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer (A/B/C/D): ");
        return scanner.next().toUpperCase().charAt(0);
    }
}

class AnswerSubmission {
    public static char submitAnswerWithinTimeLimit(QuizQuestion question, int timeLimit) {
        // Display question
        QuestionDisplay.displayQuestion(question);

        // Start timer
        Timer timer = new Timer(timeLimit);
        timer.startTimer();

        // Get user answer
        char userAnswer = QuestionDisplay.getUserAnswer();

        // Stop timer
        timer.stopTimer();

        return userAnswer;
    }
}

class ScoreCalculation {
    public static int calculateScore(QuizQuestion question, char userAnswer) {
        if (userAnswer == question.getCorrectAnswer()) {
            return 1;
        } else {
            return 0;
        }
    }
}

class ResultScreen {
    public static void displayResult(int score, int totalQuestions) {
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + totalQuestions);
    }
}

public class QuizMain {
    public static void main(String[] args) {
        // Create quiz questions
        QuizQuestion question1 = new QuizQuestion("What is the capital of France?",
                new String[]{"Paris", "London", "Rome", "Berlin"}, 'A');
        // Add more questions similarly

        // Define time limit for each question
        int timeLimit = 30; // 30 seconds

        // Initialize score
        int score = 0;

        // Process each question
        QuizQuestion[] quizQuestions = {question1}; // Add more questions here
        for (QuizQuestion question : quizQuestions) {
            char userAnswer = AnswerSubmission.submitAnswerWithinTimeLimit(question, timeLimit);
            score += ScoreCalculation.calculateScore(question, userAnswer);
        }

        // Display final result
        ResultScreen.displayResult(score, quizQuestions.length);
    }
}
