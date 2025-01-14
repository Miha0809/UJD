package Task1;

public class Question {
    String questionText;
    String[] answers = new String[3];
    char correctAnswer;

    public Question(String questionText, String[] answers, char correctAnswer) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }
}
