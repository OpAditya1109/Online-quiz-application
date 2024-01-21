import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    public String text;
    public ArrayList<String> options;
    public int correctAnswer;

    public Question(String text, ArrayList<String> options, int correctAnswer) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}

class Quiz {
    public ArrayList<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int totalQuestions = questions.size();

        for (int i = 0; i < totalQuestions; i++) {
            Question question = questions.get(i);

            System.out.println("Question " + (i + 1) + ": " + question.text);
            for (String option : question.options) {
                System.out.println(option);
            }

            System.out.print("Your answer: ");
            int userAnswer;

            while (true) {
                try {
                    userAnswer = Integer.parseInt(scanner.nextLine());
                    if (userAnswer >= 1 && userAnswer <= question.options.size()) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a valid option.");
                        System.out.print("Your answer: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid option.");
                    System.out.print("Your answer: ");
                }
            }

            if (question.isCorrect(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was " + question.correctAnswer + ": "
                        + question.options.get(question.correctAnswer - 1) + "\n");
            }
        }

        System.out.println("You scored " + score + "/" + totalQuestions + ".");
    }
}

public class main {
    public static void main(String[] args) {
        // Example Usage with more questions:
        Question question1 = new Question("What is the capital of France?",
                new ArrayList<>(List.of("1. Berlin", "2. Paris", "3. Rome")), 2);
        Question question2 = new Question("Which programming language is this example written in?",
                new ArrayList<>(List.of("1. Java", "2. Python", "3. C++")), 1);
        Question question3 = new Question("What is the largest planet in our solar system?",
                new ArrayList<>(List.of("1. Earth", "2. Jupiter", "3. Mars")), 2);
        Question question4 = new Question("Who wrote 'Romeo and Juliet'?",
                new ArrayList<>(List.of("1. William Shakespeare", "2. Charles Dickens", "3. Jane Austen")), 1);

        Quiz quiz = new Quiz();
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);
        quiz.addQuestion(question4);

        quiz.takeQuiz();
    }
}
