package Sample;

public class Questions {

    private String question;
    private String[] answers;
    private int key;

    public Questions(String question, String[] answers,int key) {
        this.question = question;
        this.answers = answers;
        this.key=key;
    }

    /*public String correctAnswer(){
        return this.answers[answers.length-1];
    }*/

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
}
