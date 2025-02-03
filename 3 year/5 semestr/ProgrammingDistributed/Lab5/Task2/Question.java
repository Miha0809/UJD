package Task2;

import java.io.Serializable;

public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    String questionText;
    String[] answers = new String[3];
    char correctAnswer;

    public Question(String questionText, String[] answers, char correctAnswer) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }
}
