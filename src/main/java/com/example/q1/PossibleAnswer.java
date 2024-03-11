public class PossibleAnswer {
    private final String answer;
    private final boolean isCorrect;

    public PossibleAnswer(String answer, boolean isCorrect) {
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PossibleAnswer) {
            return this.answer.equals(((PossibleAnswer) obj).answer) && this.isCorrect == ((PossibleAnswer) obj).isCorrect;
        }
        return false;
    }
}